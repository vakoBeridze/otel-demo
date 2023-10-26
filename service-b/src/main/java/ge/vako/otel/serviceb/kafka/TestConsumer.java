package ge.vako.otel.serviceb.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TestConsumer {

    @KafkaListener(topics = "test-topic-from-a", groupId = "service-a")
    public void consume(String message) {
        System.out.println("Message consumed: " + message);
    }
}
