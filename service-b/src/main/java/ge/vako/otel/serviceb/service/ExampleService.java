package ge.vako.otel.serviceb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleService.class);

    public String getGreetingText() {
        LOGGER.info("Getting greeting test from service-b");
        return "Hello, from service-a";
    }
}
