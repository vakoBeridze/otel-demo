package ge.vako.otel.servicea.api;

import ge.vako.otel.servicea.model.User;
import ge.vako.otel.servicea.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExampleController {
    private final UserService userService;

   public ExampleController(UserService userService) {
       this.userService = userService;
   }

    @GetMapping("/hello")
    String hello() {
        List<User> users = userService.getAllUsers();
        return "Hello, from service-a, users: " + users;
    }
}
