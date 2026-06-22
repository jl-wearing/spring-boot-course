package org.example.configurations;

import org.example.models.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {
    @Bean("iron-condor")
    @Primary
    public Parrot parrot1() {
        var parrot = new Parrot();
        parrot.setName("lika");
        return parrot;
    }

    @Bean(name = "eagle")
    public Parrot parrot2() {
        var parrot = new Parrot();
        parrot.setName("mika");
        return parrot;
    }

    @Bean(value = "goose")
    public Parrot parrot3() {
        var parrot = new Parrot();
        parrot.setName("nika");
        return parrot;
    }
}
