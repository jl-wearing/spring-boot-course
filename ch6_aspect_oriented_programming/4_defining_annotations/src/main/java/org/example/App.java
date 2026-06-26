package org.example;

import org.example.configurations.ProjectConfig;
import org.example.models.Comment;
import org.example.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class App {
    public static void main(String[] args) {
        // Define the context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Retrieve the instances from the context.
        var commentService = context.getBean(CommentService.class);

        // Publish a comment.
        Comment comment = new Comment();
        comment.setAuthor("Laurentiu Spilca");
        comment.setText("This is a comment");
        commentService.deleteComment(comment);

        // Testing the afterreturning aspect annotation.
        String text = commentService.getComment(comment);

    }
}