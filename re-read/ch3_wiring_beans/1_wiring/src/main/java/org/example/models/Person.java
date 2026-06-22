package org.example.models;

public class Person {
    private String name;
    private Parrot parrot;

    public void setName(String name) {
        this.name = name;
    }

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }

    public Parrot getParrot () {
        return parrot;
    }

    public String getName () {
        return name;
    }

    @Override
    public String toString () {
        return this.getClass().getSimpleName() + "[name=" + name + ", parrot = " + parrot + "]";
    }
}
