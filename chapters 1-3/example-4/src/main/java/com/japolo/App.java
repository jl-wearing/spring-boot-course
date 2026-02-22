package com.japolo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import models.Parrot;
import config.ProjectConfig;

public class App {
    public static void main(String[] args) {
        // Initialize the Spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Get instances of a Parrot from the spring context.
        Parrot p = context.getBean(Parrot.class);
        System.out.println(p);
        p.setName("Kiwi");
        System.out.println(p.getName());
    }
}