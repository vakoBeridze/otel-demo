package ge.vako.otel.servicea.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    @GetMapping("/hello")
    String hello() {
        return "Hello, from service-a";
    }
}
