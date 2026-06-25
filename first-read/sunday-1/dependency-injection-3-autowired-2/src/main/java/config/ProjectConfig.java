package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import models.*;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "models")
public class ProjectConfig {
    @Bean
    @Primary
    public Parrot parrot1() {
        Parrot parrot = new Parrot();
        parrot.setName("p1");
        return parrot;
    }

    @Bean
    @Qualifier("parrot2")
    public Parrot parrot2() {
        Parrot parrot = new Parrot();
        parrot.setName("p2");
        return parrot;
    }
}
