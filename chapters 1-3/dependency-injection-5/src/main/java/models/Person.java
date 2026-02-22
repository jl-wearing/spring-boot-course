package models;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;
    private final Parrot parrot;
    // Using constructor injection allows you to make an instance variable final to prevent it from being altered after initialization.

    @Autowired
    public Person(Parrot parrot) { this.parrot = parrot; }
    // If there is only 1 constructor in the class, @Autowired can be removed/is not necessary.

    public void setName(String name) { this.name = name; }
    public String getName() { return this.name; }

    public Parrot getParrot () { return this.parrot; }

    @PostConstruct
    public void init() {
        this.name = "Ella";
    }
}
