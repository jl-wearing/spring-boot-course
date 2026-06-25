package config;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import models.*;

/*
You can use dependency injection to define a relationship between beans. But what if you have multiple beans?
The first method is to use the Qualifier annotation.
The second method is to use one of its attributes as the qualifier.
 */

@Configuration
public class ProjectConfig {
    @Bean
    @Qualifier("parrotOne")
    public Parrot parrot1() {
        Parrot parrot = new Parrot();
        parrot.setName("parrot 1");
        return parrot;
    }

    @Bean
    @Qualifier("parrotTwo")
    public Parrot parrot2() {
        Parrot parrot = new Parrot();
        parrot.setName("parrot 2");
        return parrot;
    }

    @Bean
    public Person person(@Qualifier("parrotTwo") Parrot parrot) {
        Person person = new Person();
        person.setName("Thomas");
        person.setParrot(parrot);
        return person;
    }
}
