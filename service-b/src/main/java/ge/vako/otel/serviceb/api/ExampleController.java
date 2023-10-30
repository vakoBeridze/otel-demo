package ge.vako.otel.serviceb.api;

import ge.vako.otel.serviceb.service.ExampleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ExampleController {
    private final RestTemplate restTemplate;
    private final ExampleService exampleService;

    public ExampleController(RestTemplate restTemplate, ExampleService exampleService) {
        this.restTemplate = restTemplate;
        this.exampleService = exampleService;
    }

    @GetMapping("/hello")
    String hello() {
        String greetingText = exampleService.getGreetingText();
        ResponseEntity<String> stringResponseEntity = restTemplate.getForEntity("http://service-a1:8081/a/hello", String.class);
        return greetingText + " " + stringResponseEntity.getBody();
    }

    @GetMapping("/error")
    String error() {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Really bad request");
    }
}
