package org.example.configurations;

import org.example.models.Parrot;
import org.example.models.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    @Qualifier("p1")
    public Parrot parrot1() {
        Parrot parrot = new Parrot();
        parrot.setName("kila");
        return parrot;
    }

    @Bean
    @Qualifier("p2")
    public Parrot parrot2() {
        Parrot parrot = new Parrot();
        parrot.setName("lila");
        return parrot;
    }

    @Bean
    @Qualifier("p3")
    public Parrot parrot3() {
        Parrot parrot = new Parrot();
        parrot.setName("mila");
        return parrot;
    }

    @Bean
    public Person person(@Qualifier("p2") Parrot parrot) {
        Person person = new Person();
        person.setName("messi");
        person.setParrot(parrot);
        return person;
    }
}
