package main;

import services.*;
import models.Penguin;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Initialize the Spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Retrieve 2 instances of Penguin from the context.
        var p1 = context.getBean(Penguin.class);
        var p2 = context.getBean(Penguin.class);

        // Verify that they refer to different penguin instances because of the prototype scope.
        System.out.println(p1 == p2);
        System.out.println();

        // Retrieve 2 service instances from the context.
        var commentService = context.getBean(CommentService.class);
        var userService = context.getBean(UserService.class);

        // Verify that the service dependency refer to different objects.
        System.out.println(commentService.getCommentRepository() == userService.getCommentRepository());
    }
}