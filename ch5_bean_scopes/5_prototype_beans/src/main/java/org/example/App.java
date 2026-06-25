package org.example;

import org.example.configurations.ProjectConfig;
import org.example.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Define the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Retrieve 2 instances.
        var cs1 = context.getBean(CommentService.class);
        var cs2 = context.getBean(CommentService.class);

        // Determine if they refer to the same instane.
        System.out.println(cs1 == cs2);
    }
}