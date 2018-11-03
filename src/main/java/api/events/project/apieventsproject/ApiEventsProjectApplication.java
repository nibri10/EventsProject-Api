package api.events.project.apieventsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApiEventsProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiEventsProjectApplication.class, args);
    }
}
