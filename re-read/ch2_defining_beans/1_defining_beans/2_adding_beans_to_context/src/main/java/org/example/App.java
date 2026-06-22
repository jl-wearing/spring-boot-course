package org.example;

import org.example.configurations.ProjectConfig;
import org.example.models.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Define the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Get the parrot instance from the Spring Context.
        var parrot = context.getBean(Parrot.class);

        // Output the parrot's name.
        System.out.println(parrot.getName());

        // Get the other instances in the context.
        var ten =  context.getBean(Integer.class);
        var greeting = context.getBean(String.class);

        // Output the values in the context.
        System.out.println(greeting);
        System.out.println(ten);
    }
}
