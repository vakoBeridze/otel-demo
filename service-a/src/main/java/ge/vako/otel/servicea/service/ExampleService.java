package ge.vako.otel.servicea.service;

import ge.vako.otel.servicea.kafka.TestProducer;
import ge.vako.otel.servicea.model.User;
import ge.vako.otel.servicea.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleService {

    private final TestProducer testProducer;
    private final UserRepository userRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleService.class);

    public ExampleService(TestProducer testProducer, UserRepository userRepository) {
        this.testProducer = testProducer;
        this.userRepository = userRepository;
    }


    public List<User> getUsers() {
        LOGGER.info("Getting users from service-a");
        return userRepository.findAll();
    }

    public String getGreetingText() {
        LOGGER.info("Getting greeting from service-a");
        return "Hello, from service-a";
    }

    public void sendMessage() {
        testProducer.send("1");
    }
}
