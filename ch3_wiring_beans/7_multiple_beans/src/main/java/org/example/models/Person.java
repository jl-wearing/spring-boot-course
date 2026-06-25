package org.example.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Person {
    private String name;
    private Parrot parrot;


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


    public Parrot getParrot () {
        return parrot;
    }
    public void setParrot (Parrot parrot ) {
        this.parrot = parrot;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", parrot=" + parrot + "]";
    }
}
