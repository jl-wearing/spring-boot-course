package services;

import aspects.ToLog;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;
import models.Comment;

@Service
public class CommentService {
    private Logger logger;

    @ToLog
    public String publishComment(Comment comment) {
        logger.info("Publishing comment: " + comment.getText());
        return "SUCCESS";
    }

    @PostConstruct
    public void init() {
        logger = Logger.getLogger(CommentService.class.getName());
    }
}
