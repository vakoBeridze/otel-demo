package ge.vako.otel.serviceb.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ExampleController {
    private final RestTemplate restTemplate;

    public ExampleController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/hello")
    String hello() {
        ResponseEntity<String> stringResponseEntity = restTemplate.getForEntity("http://localhost:8081/a/hello", String.class);
        return "Hello from service-b and " + stringResponseEntity.getBody();
    }

    @GetMapping("/error")
    String error() {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Really bad request");
    }
}
