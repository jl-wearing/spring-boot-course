package config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import models.*;

@Configuration
public class ProjectConfig {
    @Bean
    public Parrot parrot() {
        Parrot parrot = new Parrot();
        parrot.setName("Koko");
        return parrot;
    }

    @Bean
    public Person person(Parrot parrot) {       // Second form of dependency injection. But what if we have 2 beans of the same type in the context?
        Person person = new Person();
        person.setName("Koko");
        person.setParrot(parrot);
        return person;
    }
}
