package main;

import models.Comment;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;
import java.util.logging.Logger;

public class App {
    public static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        // Initialize the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Define a comment to be published.
        Comment comment = new Comment();
        comment.setAuthor("Wearing");
        comment.setText("Demo comment");

        // Publish the comment.
        var service = context.getBean(CommentService.class);
        String result = service.publishComment(comment);

        // Logging the value returned.
        LOGGER.info(result);
    }
}