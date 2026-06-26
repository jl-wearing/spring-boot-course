package org.example;

import org.example.configurations.ProjectConfig;
import org.example.models.Comment;
import org.example.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        // Define the context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Retrieve the instance from the context.
        var commentService = context.getBean(CommentService.class);

        // Publish a comment.
        Comment comment = new Comment();
        comment.setAuthor("Laurentiu Spilca");
        comment.setText("Hello World");
        String returnValue = commentService.publishComment(comment);

        // Log the returned value.
        LOGGER.info("Returned: " + returnValue);
    }
}