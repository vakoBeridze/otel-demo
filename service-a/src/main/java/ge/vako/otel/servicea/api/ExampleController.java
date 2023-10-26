package ge.vako.otel.servicea.api;

import ge.vako.otel.servicea.service.ExampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    private final ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping("/hello")
    String hello() {
        return "Hello, from service-a";
    }

    @GetMapping("/kafka")
    void sendKafka() {
        exampleService.sendMessage();
    }
}
