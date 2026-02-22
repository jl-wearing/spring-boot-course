package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import models.*;
import config.ProjectConfig;

public class App {
    public static void main(String[] args) {
        // Initialize the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Get the Parrot instances from the context.
        var p1 = context.getBean("parrot1", Parrot.class);
        var p2 = context.getBean("parrot2", Parrot.class);
        System.out.println(p1);
        System.out.println(p2);

        // Get the Person instance from the context.
        var person = context.getBean(Person.class);
        System.out.println("\n" + person.getName());
        System.out.println(person.getParrot());
    }
}