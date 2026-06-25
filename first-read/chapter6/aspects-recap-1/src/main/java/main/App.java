package main;

import models.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import config.ProjectConfig;
import services.CommentService;

public class App {
    public static void main(String[] args) {
        // Initialize the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Define a comment to be published.
        Comment comment = new Comment();
        comment.setAuthor("Wearing");
        comment.setText("Demo comment");
        System.out.println(comment);

        // Publish the comment.
        var service = context.getBean(CommentService.class);
        service.publishComment(comment);
    }
}