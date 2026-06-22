package org.example;

import org.example.models.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Define the spring context.
        var context = new AnnotationConfigApplicationContext();

        // Define an instance.
        Parrot p = new Parrot ();
        p.setName("George");
    }
}
