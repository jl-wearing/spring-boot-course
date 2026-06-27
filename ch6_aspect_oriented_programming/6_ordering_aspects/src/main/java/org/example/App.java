package org.example;

import org.example.configurations.ProjectConfig;
import org.example.models.Comment;
import org.example.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Define the context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Publish a comment.
        var comment = new Comment();
        comment.setAuthor("Laurentiu Spilca");
        comment.setText("Demo Comment");
        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}