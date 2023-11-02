## OpenTelemetry Collector Extensions

### Memory Ballast 
- [GitHub Repository](https://github.com/open-telemetry/opentelemetry-collector/tree/main/extension/ballastextension)
- increase size of the heap to reduce garbage collector cycles for the collector, will reduce cpu usage.
- Configuration options:
  - `size_mib`:
  - `size_in_percentage` - in k8s env = limit * size_in_percentage / 100

### Healthcheck 
- [GitHub Repository](https://github.com/open-telemetry/opentelemetry-collector-contrib/tree/main/extension/healthcheckextension)
- enables http endpoint for checking collector status - can be used as liveness/readiness probe.

### ZPages 
- [GitHub Repository](https://github.com/open-telemetry/opentelemetry-collector/blob/main/extension/zpagesextension/README.md)
- enabled http endpoint which provides live data for debugging different collector components.
  Example: visiting http://localhost:55679/debug/servicez -> pipelines we can see collector pipelines

### PProf 
- [GitHub Repository](https://github.com/open-telemetry/opentelemetry-collector-contrib/tree/main/extension/pprofextension)
- enables the golang net/http/pprof endpoint. This is typically used by developers to collect performance profiles and investigate issues with the service.
- problem: http://localhost:1888/ - 404 when setting port to 1888 in otel collector yml - docker compose was exposing it on 1888.

### Kubernetes Observer 
- [GitHub Repository](https://github.com/open-telemetry/opentelemetry-collector-contrib/blob/main/extension/observer/k8sobserver/README.md)
- get kubernetes info via pod, port and node endpoints. other collector components can subscribe to observers,
  currently only receiver creator - [GitHub Repository](https://github.com/open-telemetry/opentelemetry-collector-contrib/blob/main/receiver/receivercreator/README.md).
  receiver creator is used to create receivers at runtime based on rule config, where we can input values provided by k8s observer in this case

#### Example Configuration:
```yaml
extensions:
    k8s_observer:
        auth_type: serviceAccount
        node: ${env:K8S_NODE_NAME}
        observe_pods: true
        observe_nodes: true

receivers:
    receiver_creator:
        watch_observers: [k8s_observer] // subscribe to k8s observer
        receivers:
            redis:
                rule: type == "port" && pod.name matches "redis" // gets pod name from k8s observer

service:
    pipelines:
        metrics:
        receivers: [receiver_creator]
        processors: [exampleprocessor]
        exporters: [exampleexporter]
    extensions: [k8s_observer]
