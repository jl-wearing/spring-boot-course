package main;
import models.*;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Initialize the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Retrieve the parrot instance from the context.
        var parrot = context.getBean(Parrot.class);
        System.out.println(parrot.getName());

        // Retrieve the person instance from the context.
        var person = context.getBean(Person.class);
        System.out.println(person.getName());
        System.out.println(person.getParrot());
    }
}