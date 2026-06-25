package config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import models.Parrot;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {
    // You can define beans that refer to instances of the same class and add them to the context.
    @Primary
    @Bean
    Parrot parrot1() {
        var p = new Parrot();
        p.setName("Kiwi");
        return p;
    }

    @Bean(name = "Lila")
    Parrot parrot2() {
        var p = new Parrot();
        p.setName("Lila");
        return p;
    }

    @Bean
    Parrot parrot3() {
        var p = new Parrot();
        p.setName("Ziggy");
        return p;
    }
}
