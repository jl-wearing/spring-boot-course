package main;

import models.Parrot;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Initialize the Spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Return a parrot instance from the context.
        var parrot = context.getBean(Parrot.class);
        System.out.println(parrot.getName());

        // Get 10 from the context.
        var ten = context.getBean(Integer.class);
        System.out.println(ten);

        // Get the string hello from the context.
        var hello = context.getBean(String.class);
        System.out.println(hello);

        // Get the second parrot from the context.
        var parrot2 = context.getBean("parrot2", Parrot.class);
        System.out.println(parrot2.getName());

        // Get the third parrot from the context.
        var parrot3 = context.getBean("nandos", Parrot.class);
        System.out.println(parrot3.getName());
    }
}