package config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import models.Parrot;

@Configuration
public class ProjectConfig {
    @Bean
    Parrot parrot() {
        var parrot = new Parrot();
        parrot.setName("Kiwi");
        return parrot;
        // The spring context will now be aware of this Parrot instance.
    }

    // You can add any object to the Spring context to make Spring aware of it.
    @Bean
    String hello() {
        return "Hello";
    }

    @Bean
    Integer ten() {
        return 10;
    }
}
