package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import models.Parrot;

@Configuration
@ComponentScan(basePackages = "models")
public class ProjectConfig {
    @Bean
    public Parrot parrot1() {
        Parrot parrot = new Parrot();
        parrot.setName("koko");
        return parrot;
    }

    @Bean
    public Parrot parrot2() {
        Parrot parrot = new Parrot();
        parrot.setName("lolo");
        return parrot;
    }

    @Bean
    public Parrot parrot3() {
        Parrot parrot = new Parrot();
        parrot.setName("momo");
        return parrot;
    }
}
