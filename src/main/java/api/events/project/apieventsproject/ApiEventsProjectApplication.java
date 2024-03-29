package api.events.project.apieventsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@RestController
@EnableJpaAuditing
public class ApiEventsProjectApplication {


    public static void main(String[] args) {
        SpringApplication.run(ApiEventsProjectApplication.class, args);
    }


    @RequestMapping("/home")
    public String hello() {
        return "Hello buddy!";
    }
}
