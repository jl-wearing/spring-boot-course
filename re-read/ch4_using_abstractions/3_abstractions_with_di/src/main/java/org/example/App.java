package org.example;

import org.example.configurations.ProjectConfiguration;
import org.example.models.Comment;
import org.example.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args ) {
        // Define the context.
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        // Define a comment to b published.
        var comment = new Comment();
        comment.setAuthor("Laurentiu Spilca");
        comment.setText("Spring Security in Action Chapter 1");

        // publish the comment.
        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}
