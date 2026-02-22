package com.japolo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import models.Parrot;
import config.ProjectConfig;

public class App {
    public static void main(String[] args) {
        // Initialize the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Get the parrot instance from the context.
        Parrot p = context.getBean("Lila", Parrot.class);
        System.out.println(p.getName());

        // Get the primary parrot bean.
        Parrot p2 = context.getBean(Parrot.class);
        System.out.println(p2.getName());
    }
}
