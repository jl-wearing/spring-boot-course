package models;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;
    private Parrot parrot;

    @Autowired
    public Person(@Qualifier("parrot2") Parrot parrot) { this.parrot = parrot; }
    // The first way to constructor inject by autowire is to provide as a parameter, the name of the bean you want to inject.

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    public void setParrot(Parrot parrot) { this.parrot = parrot; }
    public Parrot getParrot () { return parrot; }

    @PostConstruct
    public void init() { this.name = "Ella"; }
}
