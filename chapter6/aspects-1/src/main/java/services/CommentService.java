package services;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import models.Comment;

import java.util.logging.Logger;

@Service
public class CommentService {
    private Logger logger;

    public void publishComment(Comment comment) {
        logger.info("Publishing comment: " + comment.getText());
    }

    @PostConstruct
    public void init() {
        logger = Logger.getLogger(CommentService.class.getName());
    }
}