package ge.vako.otel.servicea.api;

import ge.vako.otel.servicea.service.ExampleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ExampleController {

    @Value("${service-b-url}")
    String serviceBUrl;

    private final RestTemplate restTemplate;
    private final ExampleService exampleService;

    public ExampleController(RestTemplate restTemplate, ExampleService exampleService) {
        this.restTemplate = restTemplate;
        this.exampleService = exampleService;
    }

    @GetMapping("/hello")
    String hello() {
        return exampleService.getGreetingText();
    }

    @GetMapping("/data")
    String error() {
        ResponseEntity<String> responseEntity = this.restTemplate.postForEntity("https://httpbin.org/post", "Hello, World!", String.class);
        return responseEntity.getBody();
    }

    @GetMapping("/data/{statusCode}")
    String status(@PathVariable String statusCode) {
        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity("https://httpbin.org/status/" + statusCode, String.class);
        return responseEntity.getBody();
    }
}
