package org.example;

import org.example.configurations.ProjectConfig;
import org.example.services.CommentService;
import org.example.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Define the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Retrieve the instances from the context.
        var userService = context.getBean(UserService.class);
        var commentService = context.getBean(CommentService.class);

        // Determine if their repository instances are the same.
        System.out.println(userService.getCommentRepository() == commentService.getCommentRepository());
    }
}