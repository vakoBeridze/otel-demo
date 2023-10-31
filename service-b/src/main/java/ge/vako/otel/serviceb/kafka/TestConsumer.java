package ge.vako.otel.serviceb.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TestConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestConsumer.class);

    private final TestProducer producer;

    public TestConsumer(TestProducer producer) {
        this.producer = producer;
    }

    @KafkaListener(topics = "test-topic-from-a")
    public void consume(String message) {
        LOGGER.info("Message consumed in service-b: " + message);
        int count = Integer.parseInt(message);
        count++;
        if (count < 6) {
            producer.send(Integer.toString(count));
        }
    }
}
