package config;
import models.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class ProjectConfig {
    @Bean
    @Qualifier("parrotOne")
    public Parrot parrot1() {
        Parrot parrot = new Parrot();
        parrot.setName("KFC");
        return parrot;
    }

    @Bean
    @Qualifier("parrotTwo")
    public Parrot parrot2() {
        Parrot parrot = new Parrot();
        parrot.setName("Nandos");
        return parrot;
    }

    @Bean
    @Qualifier("parrotThree")
    public Parrot parrot3() {
        Parrot parrot = new Parrot();
        parrot.setName("Chicken Licken");
        return parrot;
    }

    @Bean
    public Person person(@Qualifier("parrotTwo") Parrot parrot) {
        Person person = new Person();
        person.setName("Ella");
        person.setParrot(parrot);
        return person;
    }
}
