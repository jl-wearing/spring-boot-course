package com.japolo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import models.Parrot;
import config.ProjectConfig;

// Configuring the Spring context with Beans.
public class App {
    public static void main(String[] args) {
        // Initialize the Spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Get the first bean from the context.
        Parrot p1 = context.getBean("getParrot", Parrot.class);
        System.out.println(p1.getName());

        // TEST: Get the second bean, and see what its name is.
        Parrot p2 = context.getBean("test", Parrot.class);
        System.out.println(p2.getName());

        // Get the primary bean.
        Parrot primary = context.getBean(Parrot.class);
        System.out.println(primary.getName());
    }
}
