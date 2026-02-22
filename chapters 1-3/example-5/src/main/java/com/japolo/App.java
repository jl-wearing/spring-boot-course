package com.japolo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import models.Parrot;
import config.ProjectConfig;

public class App {
    public static void main(String[] args) {
        // Initialize the Spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Get an instance of Parrot from the context.
        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());
    }
}