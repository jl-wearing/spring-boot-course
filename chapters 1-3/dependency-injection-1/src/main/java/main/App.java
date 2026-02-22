package main;

import models.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import config.ProjectConfig;

public class App {
    public static void main(String[] args) {
        // Initialize the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Get the Parrot instance from the context.
        var parrot = context.getBean(Parrot.class);
        System.out.println(parrot.toString());

        // Get the Person instance from the context.
        var person = context.getBean(Person.class);
        System.out.println(person.getName());

        // Print the person's parrot to prove that there's not yet a relationship between the instances.
        System.out.println(person.getParrot());
    }
}