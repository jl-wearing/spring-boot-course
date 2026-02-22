package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import models.*;

@Configuration
public class ProjectConfig {
    @Bean
    public Parrot parrot() {
        Parrot parrot = new Parrot();
        parrot.setName("Nandos");
        return parrot;
    }

    @Bean
    public Person person(Parrot parrot) {
        Person person = new Person();
        person.setName("Ella");
        person.setParrot(parrot);
        return person;
    }
    /*
    By defining a parameter to the person bean, we instruct spring to provide us a bean of the type of that parameter
    from its context.
    When calling the method, Spring knows it has to find a Parrot bean from its context, and inject its value into
    the parameter of the person() method.
     */
}
