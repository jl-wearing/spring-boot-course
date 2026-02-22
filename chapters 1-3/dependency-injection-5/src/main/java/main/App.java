package main;

import models.*;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Initialize the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Get an instance of Parrot from the context.
        var parrot = context.getBean(Parrot.class);
        System.out.println(parrot.getName());

        // Get an instance of Person from the context.
        var person = context.getBean(Person.class);
        System.out.println(person.getName());
        System.out.println(person.getParrot());
    }
}