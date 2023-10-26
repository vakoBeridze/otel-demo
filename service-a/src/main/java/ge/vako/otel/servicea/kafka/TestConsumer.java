package ge.vako.otel.servicea.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TestConsumer {

    @KafkaListener(topics = "test-topic-from-b", groupId = "test")
    public void consume(String message) {
        System.out.println("Message consumed: " + message);
    }
}
