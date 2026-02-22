package config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import models.Parrot;

@Configuration
public class ProjectConfig {
    // Using Beans to configure the Spring Context.

    @Bean
    public Parrot getParrot() {
        Parrot parrot = new Parrot();
        parrot.setName("name1");
        return parrot;
    }

    @Bean(name = "test")
    @Primary
    public Parrot getParrot2() {
        Parrot parrot = new Parrot();
        parrot.setName("name2");
        return parrot;
    }
}
