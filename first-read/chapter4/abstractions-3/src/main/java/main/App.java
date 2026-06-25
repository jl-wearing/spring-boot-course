package main;

import models.*;
import proxies.*;
import repositories.*;
import services.*;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Initialize the Spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Create a comment to be published.
        Comment comment = new  Comment();
        comment.setAuthor("Wearing");
        comment.setText("Demo comment");

        // Publish the comment.
        var commentService = context.getBean(CommentService.class);
        commentService.publish(comment);
    }
}