package main;

import models.Comment;
import services.CommentService;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Initialize the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Define a comment.
        Comment comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Wearing");

        // Publish the comment.
        var service = context.getBean(CommentService.class);
        service.publishComment(comment);

        // Observe the service class that is retrieved from the context.
        System.out.println(service.getClass().getName());
    }
}