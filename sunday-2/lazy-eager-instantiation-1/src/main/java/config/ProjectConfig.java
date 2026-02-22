package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import models.*;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan(basePackages = {"models"})
public class ProjectConfig {
    @Bean
    @Lazy(value = true)
    public Parrot parrot() {
        Parrot parrot = new Parrot();
        parrot.setName("parrot");
        return parrot;
    }
}
