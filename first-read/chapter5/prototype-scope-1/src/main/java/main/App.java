package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;
import config.ProjectConfig;

public class App {
    public static void main(String[] args) {
        // Initialize the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Retrieve commentService instances.
        var cs1 = context.getBean(CommentService.class);
        var cs2 = context.getBean(CommentService.class);

        // Determine if they refer to the same object.
        System.out.println(cs1 == cs2);
    }
}