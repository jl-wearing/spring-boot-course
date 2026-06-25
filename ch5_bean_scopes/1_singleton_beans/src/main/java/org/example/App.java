package org.example;

import org.example.configurations.ProjectConfig;
import org.example.models.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Define the context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Retrieve the only parrot instance from the context.
        var p1 = context.getBean(Parrot.class);
        var p2 = context.getBean(Parrot.class);

        // Determine if they refer to the same instance.
        System.out.println(p1 == p2);
    }
}
