package main;

import models.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import proxies.*;
import repositories.*;
import services.*;
import config.ProjectConfiguration;

public class App {
    public static void main(String[] args) {
        // Initialize the Spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        // Define a comment to be published.
        Comment comment = new Comment();
        comment.setAuthor("Wearing");
        comment.setText("Demo comment");


        // Publish the comment.
        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}