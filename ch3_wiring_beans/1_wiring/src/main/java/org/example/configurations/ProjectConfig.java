package org.example.configurations;

import org.example.models.Parrot;
import org.example.models.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    public Parrot parrot() {
        Parrot parrot = new Parrot();
        parrot.setName("Poop");
        return parrot;
    }

    @Bean
    public Person person() {
        Person person = new Person();
        person.setName("John");
        person.setParrot(parrot());
        return person;
    }
}
