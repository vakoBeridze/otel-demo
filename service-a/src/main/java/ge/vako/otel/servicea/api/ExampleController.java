package ge.vako.otel.servicea.api;

import ge.vako.otel.servicea.kafka.TestProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    private final TestProducer testProducer;

    public ExampleController(TestProducer testProducer) {
        this.testProducer = testProducer;
    }

    @GetMapping("/hello")
    String hello() {
        return "Hello, from service-a";
    }

    @PostMapping("/kafka")
    void sendKafka() {
        testProducer.send("kafka message");
    }
}
