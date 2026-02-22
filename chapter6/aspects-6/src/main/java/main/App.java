package main;

import aspects.*;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;
import models.Comment;
import java.util.logging.Logger;

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        // Initialize the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Define a comment to be deleted.
        Comment comment = new Comment();
        comment.setAuthor("Wearing");
        comment.setText("Demo comment");

        // Delete the comment.
        var service = context.getBean(CommentService.class);
        String result = service.deleteComment(comment);

        // Log the result returned.
        LOGGER.info("Result returned: " + result);
    }
}