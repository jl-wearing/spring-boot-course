package models;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;
    private Parrot parrot;

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    @Autowired
    public void setParrot(@Qualifier("parrot2") Parrot parrot) { this.parrot = parrot; }
    public Parrot getParrot () { return this.parrot; }

    @PostConstruct
    public void init() { this.name = "Ella"; }
}
