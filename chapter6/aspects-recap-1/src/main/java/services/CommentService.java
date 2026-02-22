package services;

import jakarta.annotation.PostConstruct;
import models.Comment;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;

@Service
public class CommentService {
    private Logger logger;

    public String publishComment(Comment comment){
        logger.info("Publishing comment: " + comment.getText());
        return "SUCCESS";
    }

    @PostConstruct
    public void init() {
        logger = Logger.getLogger(CommentService.class.getName());
    }
}
