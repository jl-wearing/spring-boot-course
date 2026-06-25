package services;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;
import models.Comment;
import aspects.ToLog;

@Service
public class CommentService {
    private Logger logger;

    public void publishComment(Comment comment) {
        logger.info("Publishing comment: " + comment.getText());
    }

    @ToLog
    public void deleteComment(Comment comment) {
        logger.info("Deleting comment: " + comment.getText());
    }

    public void editComment(Comment comment) {
        logger.info("Editing comment: " + comment.getText());
    }

    @PostConstruct
    public void init() {
        logger = Logger.getLogger(CommentService.class.getName());
    }
}
