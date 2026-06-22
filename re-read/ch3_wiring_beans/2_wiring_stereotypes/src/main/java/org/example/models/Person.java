package org.example.models;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;
    private Parrot parrot;

    @Autowired
    public Person(Parrot parrot) {
        this.parrot = parrot;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }

    public Parrot getParrot() {
        return this.parrot;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[name=" + name + "]" + ", [parrot=" + parrot + "]";
    }

    @PostConstruct
    public void init() {
        this.name = "messi";
    }
}
