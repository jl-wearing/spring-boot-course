package main;

import models.Comment;
import config.ProjectConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import proxies.*;
import repositories.*;
import services.*;

public class App {
    public static void main(String[] args) {
        // Initialize the Spring context.
        var context =  new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        // Define a comment to publish.
        Comment comment = new Comment();
        comment.setAuthor("Wearing");
        comment.setText("Demo Comment");

        // Publish the comment.
        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}