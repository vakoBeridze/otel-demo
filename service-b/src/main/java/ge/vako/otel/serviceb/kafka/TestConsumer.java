package ge.vako.otel.serviceb.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class TestConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestConsumer.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public TestConsumer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "test-topic-from-a", groupId = "service-a")
    public void consume(String message) {
        LOGGER.info("Message consumed in service-b: " + message);
        kafkaTemplate.send("test-topic-from-b", message);
    }
}
