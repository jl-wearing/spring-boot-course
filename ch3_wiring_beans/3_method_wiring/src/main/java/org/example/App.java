package org.example;

import org.example.configurations.ProjectConfig;
import org.example.models.Parrot;
import org.example.models.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args ) {
        // Define the context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Retrieve the instances from the context.
        var parrot = context.getBean(Parrot.class);
        System.out.println(parrot.toString());

        var person = context.getBean(Person.class);
        System.out.println(person.toString());
    }
}
