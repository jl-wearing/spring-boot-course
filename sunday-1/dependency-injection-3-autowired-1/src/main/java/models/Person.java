package models;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;
    private final Parrot parrot;

    @Autowired      // If there is only 1 constructor, you can omit the autowired annotation.
    public Person(Parrot parrot) {
        this.parrot = parrot;
    }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    public Parrot getParrot () { return parrot; }

    @PostConstruct
    public void init() { this.name = "Ella"; }
}
