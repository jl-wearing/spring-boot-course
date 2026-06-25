package main;

import models.*;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Initialize the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Get a parrot instance from the context.
        System.out.println("Before retrieving parrot instance.");
        var parrot = context.getBean(Parrot.class);
        System.out.println("After retrieving parrot instance.");

        // Get a comment instance from the context.
        var comment = context.getBean(Comment.class);
    }
}