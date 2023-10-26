package ge.vako.otel.servicea.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TestConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestConsumer.class);

    @KafkaListener(topics = "test-topic-from-b", groupId = "test")
    public void consume(String message) {
        LOGGER.info("Message consumed in service-a: " + message);
    }
}
