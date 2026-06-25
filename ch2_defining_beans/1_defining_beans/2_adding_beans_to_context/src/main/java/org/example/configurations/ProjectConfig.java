package org.example.configurations;

import org.example.models.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    public Parrot parrot() {
        var p = new Parrot();
        p.setName("Manny");
        return p;
    }

    @Bean
    public String hello() { return "Hello World!"; }

    @Bean
    public Integer ten() { return 10; }
}
