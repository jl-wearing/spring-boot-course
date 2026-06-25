package com.japolo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import models.Parrot;
import config.ProjectConfig;

public class App {
    public static void main(String[] args) {
        // Get an instance of the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Get an instance of Parrot from the Spring context.
        var instance = context.getBean(Parrot.class);
        System.out.println(instance.getName());
        instance.setName("Nandos");
        System.out.println(instance.getName());
    }
}