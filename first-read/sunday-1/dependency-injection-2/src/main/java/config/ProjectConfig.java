package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import models.*;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {
    @Bean
    @Primary
    public Parrot parrot() {
        Parrot parrot = new Parrot();
        parrot.setName("Chicken Licken");
        return parrot;
    }

    @Bean
    @Qualifier("nando")
    public Parrot parrot2() {
        Parrot parrot = new Parrot();
        parrot.setName("Nandos");
        return parrot;
    }

    @Bean
    public Person person(@Qualifier("nando")Parrot parrot) {
        Person person = new Person();
        person.setName("Ella");
        person.setParrot(parrot);
        return person;
    }
}
