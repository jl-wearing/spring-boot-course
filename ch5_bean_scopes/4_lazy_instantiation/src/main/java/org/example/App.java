package org.example;

import org.example.configurations.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Define the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    }
}