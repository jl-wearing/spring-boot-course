package main;

import models.Comment;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

import java.util.logging.Logger;

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        // Initialize the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Define a comment to be published, edited, and deleted.
        Comment comment = new Comment();
        comment.setAuthor("Wearing");
        comment.setText("Demo comment");

        // Publish the comment.
        var service = context.getBean(CommentService.class);
        service.publishComment(comment);

        // Delete the comment.
        service.deleteComment(comment);

        // Edit the comment.
        service.editComment(comment);
    }
}