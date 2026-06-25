package config;
import org.springframework.context.annotation.Configuration;
import models.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {
    @Bean(name = "Thomas")
    Parrot parrot() {
        Parrot parrot = new Parrot();
        parrot.setName("Thomas");
        return parrot;
    }

    @Primary
    @Bean
    Parrot parrot2() {
        Parrot parrot = new Parrot();
        parrot.setName("Kentucky Fried Chicken");
        return parrot;
    }
}
