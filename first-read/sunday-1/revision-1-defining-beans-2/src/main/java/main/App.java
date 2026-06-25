package main;

import models.Parrot;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Initialize the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Retrieve the only Parrot instance from the context.
        var parrot = context.getBean(Parrot.class);
        System.out.println(parrot.getName());
    }
}