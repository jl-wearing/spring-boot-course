package org.example.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;
    private final Parrot parrot;

    @Autowired
    public Person(Parrot parrot) {
        this.parrot = parrot;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public Parrot getParrot () {
        return parrot;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[name=" + name + ", parrot=" + parrot + "]";
    }
}
