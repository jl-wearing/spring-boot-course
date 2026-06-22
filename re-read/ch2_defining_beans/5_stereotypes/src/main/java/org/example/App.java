package org.example;

import org.example.configurations.ProjectConfig;
import org.example.models.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args ) {
        // Instantiate the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Retrieve the parrot instance from the context.
        var parrot = context.getBean(Parrot.class);
        System.out.println(parrot.getName());
    }
}
