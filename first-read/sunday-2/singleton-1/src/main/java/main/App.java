package main;

import models.*;
import repositories.*;
import services.*;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Create an instance of the context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Retrieve a parrot instance from the context.
        var parrot = context.getBean(Parrot.class);

        // Prove that the default scope is the singleton scope.
        var p2 = context.getBean(Parrot.class);
        System.out.println(parrot == p2);
        System.out.println(parrot.getName().equals(p2.getName()) + "\n");

        // Declaring singleton beans using stereotype annotations.
        // Retrieve a comment instance from the context.
        var comment1 = context.getBean(Comment.class);

        // Prove that the default scope for stereotype annotations is the singleton scope.
        var comment2 = context.getBean(Comment.class);
        System.out.println(comment1 == comment2);
        System.out.println(comment1.getAuthor().equals(comment2.getAuthor()) + "\n");

        // Prove that the injected instances of commentRepository are the same.
        var userService = context.getBean(UserService.class);
        var commentService = context.getBean(CommentService.class);
        System.out.println(userService.getCommentRepository() == commentService.getCommentRepository());
    }
}