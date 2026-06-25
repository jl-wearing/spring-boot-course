package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import models.*;

public class App {
    public static void main(String[] args) {
        // Initialize the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Get the parrot instance from the context.
        var parrot = context.getBean(Parrot.class);
        System.out.println(parrot.getName());

        // Get the person instance from the context.
        var person = context.getBean(Person.class);
        System.out.println("\n" + person.getName());
        System.out.println(person.getParrot().getName());
    }
}