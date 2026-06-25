package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.*;
import repositories.CommentRepository;
import config.ProjectConfig;

public class App {
    public static void main(String[] args) {
        // Initialize the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Get service instances from the context.
        var commentService = context.getBean(CommentService.class);
        var userService = context.getBean(UserService.class);

        // Determine if the service instances refer to the same repository instance.
        System.out.println(commentService.getCommentRepository() == userService.getCommentRepository());
    }
}