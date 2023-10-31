package ge.vako.otel.serviceb.api;

import ge.vako.otel.serviceb.service.ExampleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ExampleController {

    @Value("${service-a-url}")
    String serviceAUrl;

    private final RestTemplate restTemplate;
    private final ExampleService exampleService;

    public ExampleController(RestTemplate restTemplate, ExampleService exampleService) {
        this.restTemplate = restTemplate;
        this.exampleService = exampleService;
    }

    @GetMapping("/hello")
    String hello() {
        String greetingText = exampleService.getGreetingText();
        System.err.println("serviceAUrl: " + serviceAUrl);
        ResponseEntity<String> stringResponseEntity = restTemplate.getForEntity(serviceAUrl + "/a/hello", String.class);
        return greetingText + " " + stringResponseEntity.getBody();
    }

    @GetMapping("/data")
    String error() {
        ResponseEntity<String> stringResponseEntity = restTemplate.getForEntity(serviceAUrl + "/a/data", String.class);
        return stringResponseEntity.getBody();
    }

    @GetMapping("/data/{statusCode}")
    String status(@PathVariable String statusCode) {
        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity(serviceAUrl + "/a/data/" + statusCode, String.class);
        return responseEntity.getBody();
    }
}
