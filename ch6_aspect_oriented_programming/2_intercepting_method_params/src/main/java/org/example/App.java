package org.example;

import org.example.configurations.ProjectConfig;
import org.example.models.Comment;
import org.example.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        // Define the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Get the beans from the context.
        var commentService = context.getBean(CommentService.class);

        // Publish a comment.
        Comment comment = new Comment();
        comment.setAuthor("Laurentiu Spilca");
        comment.setText("Hello World");
        String result = commentService.publishComment(comment);

        logger.info(result);
    }
}