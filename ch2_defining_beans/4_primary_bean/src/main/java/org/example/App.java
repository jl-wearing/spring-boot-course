package org.example;

import org.example.configurations.ProjectConfig;
import org.example.models.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args ) {
        // Define the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Retrieve the instances from the context.
        var p1 = context.getBean(Parrot.class);
        System.out.println(p1.getName() );

        var p2 = context.getBean("eagle", Parrot.class);
        System.out.println(p2.getName());

        var p3 = context.getBean("goose", Parrot.class);
        System.out.println(p3.getName());
    }
}
