package main;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import models.*;
import config.ProjectConfig;

public class App {
    public static void main(String[] args) {
        // Initialize the Spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Get the Parrot instance from the context.
        var parrot = context.getBean(Parrot.class);
        System.out.println(parrot.getName());

        // Get the Person instance from the context.
        var person = context.getBean(Person.class);
        System.out.println(person.getName());
        System.out.println(person.getParrot().getName());
    }
}