package config;
import models.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    public Parrot parrot1() {
        Parrot parrot = new Parrot();
        parrot.setName("parrot 1");
        return parrot;
    }

    @Bean
    public Person person() {
        Person person = new Person();
        person.setName("Ella");
        person.setParrot(parrot1());    // First way of dependency injection (establishing relationships between beans.
        return person;
    }
}
