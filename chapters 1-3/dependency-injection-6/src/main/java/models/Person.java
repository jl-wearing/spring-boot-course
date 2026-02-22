package models;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;
    private Parrot parrot;

    public void setName(String name) { this.name = name; }
    public String getName() { return this.name; }

    @Autowired
    public void setParrot(Parrot parrot) { this.parrot = parrot; }
    public Parrot getParrot () { return this.parrot; }

    @PostConstruct
    public void init() { name = "Ella"; }
}
