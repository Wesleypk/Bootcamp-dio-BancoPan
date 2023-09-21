package dio.web.api.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@EnableAutoConfiguration
public class WelcomeController {
   @GetMapping
    public String welcome(){
        return "Welcome to My Spring Boot Welcome API";
    }
}
