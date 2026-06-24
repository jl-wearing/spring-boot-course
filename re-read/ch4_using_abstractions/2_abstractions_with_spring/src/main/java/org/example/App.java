package org.example;

import org.example.configurations.ProjectConfig;
import org.example.models.Comment;
import org.example.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args ) {
        // Define the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Define a comment to be stored.
        var comment = new Comment();
        comment.setAuthor("Laurentiu Spilca");
        comment.setText("Spring Start Here Chapter 1");

        // Publish the comment.
        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}
