package org.example.configurations;

import org.example.models.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    public Parrot parrot1() {
        var p1 = new Parrot();
        p1.setName("Parrot 1");
        return p1;
    }

    @Bean
    public Parrot parrot2() {
        var p2 = new Parrot();
        p2.setName("Parrot 2");
        return p2;
    }

    @Bean
    public Parrot parrot3() {
        var p3 = new Parrot();
        p3.setName("Parrot 3");
        return p3;
    }
}
