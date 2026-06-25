package models;
import models.Parrot;

public class Person {
    private String name;
    private Parrot parrot;

    public void setName(String name) { this.name = name; }
    public String getName() { return this.name; }

    public void setParrot(Parrot parrot) { this.parrot = parrot; }
    public Parrot getParrot() { return this.parrot; }
}
