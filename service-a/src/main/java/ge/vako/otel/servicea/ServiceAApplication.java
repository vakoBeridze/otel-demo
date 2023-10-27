package ge.vako.otel.servicea;

import io.opentelemetry.contrib.attach.RuntimeAttach;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceAApplication {

    public static void main(String[] args) {
        RuntimeAttach.attachJavaagentToCurrentJvm();
        SpringApplication.run(ServiceAApplication.class, args);
    }

}
