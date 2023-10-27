package ge.vako.otel.servicea.service;

import ge.vako.otel.servicea.model.User;
import ge.vako.otel.servicea.repository.UserRepository;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @WithSpan
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
