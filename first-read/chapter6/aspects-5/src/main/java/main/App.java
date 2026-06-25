package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;
import models.Comment;
import config.ProjectConfig;

public class App {
    public static void main(String[] args) {
        // Initialize the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Define a comment to be published.
        Comment comment = new Comment();
        comment.setAuthor("Wearing");
        comment.setText("Demo comment");

        // Publish the comment.
        var service = context.getBean(CommentService.class);
        service.publishComment(comment);
    }
}