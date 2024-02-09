package ge.vako.otel.servicea.api;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActuatorMetricsConfig {

//    @Bean
//    InitializingBean s(@Qualifier("meterRegistryPostProcessor") BeanPostProcessor post, MeterRegistry meterRegistry) {
//        return () -> post.postProcessAfterInitialization(meterRegistry, "");
//    }
}
