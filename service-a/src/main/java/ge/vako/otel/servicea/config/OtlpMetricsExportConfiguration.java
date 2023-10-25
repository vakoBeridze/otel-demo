package ge.vako.otel.servicea.config;

import io.micrometer.registry.otlp.OtlpMeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtlpMetricsExportConfiguration {

    @Bean
    public OtlpMeterRegistry otlpMeterRegistry() {
        return new OtlpMeterRegistry();
    }
}
