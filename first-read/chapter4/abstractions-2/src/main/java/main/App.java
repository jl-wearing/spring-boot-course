package main;

import models.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.*;
import proxies.*;
import repositories.*;
import config.ProjectConfig;

public class App {
    public static void main(String[] args) {
        // Initialize the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var comment = new Comment();
        comment.setAuthor("Wearing");
        comment.setText("Demo comment");

        // Get the comment-service instance from the context.
        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}