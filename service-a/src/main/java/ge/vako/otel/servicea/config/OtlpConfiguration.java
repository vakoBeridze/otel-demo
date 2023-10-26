package ge.vako.otel.servicea.config;

import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtlpConfiguration {

//    @Bean
//    OtlpHttpSpanExporter otlpHttpSpanExporter() {
//        return OtlpHttpSpanExporter.builder().build();
//    }
}
