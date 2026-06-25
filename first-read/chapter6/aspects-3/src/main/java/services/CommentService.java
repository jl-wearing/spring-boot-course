package services;

import java.util.logging.Logger;

import jakarta.annotation.PostConstruct;
import models.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private Logger logger;

    public String publishComment(Comment comment) {
        logger.info("Publishing comment: " + comment.getText());
        return "SUCCESS";
    }

    @PostConstruct
    public void init() {
        logger = Logger.getLogger(CommentService.class.getName());
    }
}
