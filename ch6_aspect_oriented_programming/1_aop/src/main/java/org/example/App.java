package org.example;

import org.example.configurations.ProjectConfig;
import org.example.models.Comment;
import org.example.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // define the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Retrieve the instances from the context.
        var commentService = context.getBean(CommentService.class);

        // Publish a comment.
        var comment = new Comment();
        comment.setAuthor("Laurentiu Spilca");
        comment.setText("Hello World");
        commentService.publishComment(comment);
    }
}