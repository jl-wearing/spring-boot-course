package org.example;

import org.example.configurations.ProjectConfig;
import org.example.models.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args ) {
        // Define the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Retrieve the parrot instances from the context.
        var p1 = context.getBean("parrot1", Parrot.class);
        System.out.println(p1.getName());

        var p2 = context.getBean("parrot2", Parrot.class);
        System.out.println(p2.getName());

        var p3 = context.getBean("parrot3", Parrot.class);
        System.out.println(p3.getName());
    }
}
