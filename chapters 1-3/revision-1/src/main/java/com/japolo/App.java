package com.japolo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import models.Parrot;
import config.ProjectConfig;

public class App {
    public static void main(String[] args) {
        // Create an instance of the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Get an instance of Parrot from the spring context.
        var instance = context.getBean("Thomas", Parrot.class);
        System.out.println(instance.getName());

        // Get the primary instance of Parrot from the spring context.
        var primary = context.getBean(Parrot.class);
        System.out.println(primary.getName());
    }
}