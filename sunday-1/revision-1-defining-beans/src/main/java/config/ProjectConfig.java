package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import models.Parrot;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {
    @Bean
    @Primary
    public Parrot parrot() {
        Parrot parrot = new Parrot();
        parrot.setName("p1");
        return parrot;
    }

    @Bean
    public Parrot parrot2() {
        Parrot parrot = new Parrot();
        parrot.setName("p2");
        return parrot;
    }

    @Bean(name = "nandos")
    public Parrot parrot3() {
        Parrot parrot = new Parrot();
        parrot.setName("p3");
        return parrot;
    }

    @Bean
    public Integer ten() {
        return 10;
    }

    @Bean
    public String hello() {
        return "hello";
    }
}
