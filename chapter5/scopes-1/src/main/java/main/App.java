package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.*;
import repositories.CommentRepository;

public class App {
    public static void main(String[] args) {
        // Initialize the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Get the UserService instance from the context.
        var userService = context.getBean(UserService.class);

        // Get the CommentService instance from the context.
        var commentService = context.getBean(CommentService.class);

        // Verify that their commentRepositories refer to the same instance.
        System.out.println(userService.getCommentRepository() == commentService.getCommentRepository());
    }
}