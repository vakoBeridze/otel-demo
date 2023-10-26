package ge.vako.otel.servicea.service;

import ge.vako.otel.servicea.kafka.TestProducer;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    private final TestProducer testProducer;

    public ExampleService(TestProducer testProducer) {
        this.testProducer = testProducer;
    }

    public void sendMessage() {
        testProducer.send("1");
    }
}
