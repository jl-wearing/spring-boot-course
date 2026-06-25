package com.japolo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import config.ProjectConfig;
import models.Parrot;

public class App {
    public static void main(String[] args) {
        // Create an instance of the spring context with configurations for beans.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Get a reference of the Parrot bean from the context.
        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());

        // Get a reference of the String I added to the context.
        String st = context.getBean(String.class);
        System.out.println(st);

        // Get a reference to the Integer I added to the context.
        Integer num = context.getBean(Integer.class);
        System.out.println(num);
    }
}