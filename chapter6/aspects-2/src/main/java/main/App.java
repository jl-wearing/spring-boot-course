package main;

import models.Comment;
import services.CommentService;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.logging.Logger;

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        // Initialize the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Define a comment to be published.
        Comment comment = new Comment();
        comment.setAuthor("Wearing");
        comment.setText("Demo comment");
        // Publish the comment.
        var service = context.getBean(CommentService.class);
        String value = service.publishComment(comment);

        // Log the comment.
        LOGGER.info(value);
    }
}