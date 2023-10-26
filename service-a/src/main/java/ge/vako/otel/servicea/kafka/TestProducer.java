package ge.vako.otel.servicea.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class TestProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    public TestProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String message) {
        LOGGER.info("Sent message from service-a: " + message);
        kafkaTemplate.send("test-topic-from-a", message);
    }
}
