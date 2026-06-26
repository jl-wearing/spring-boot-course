package org.example.services;

import org.example.aspects.logging.ToLog;
import org.example.models.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {
    private static Logger LOGGER = Logger.getLogger(CommentService.class.getName());

    public void publishComment(Comment comment) {
        LOGGER.info("Publishing comment " + comment.getText());
    }

    @ToLog
    public void deleteComment(Comment comment) {
        LOGGER.info("Deleting comment " + comment.getText());
    }

    public void editComment(Comment comment) {
        LOGGER.info("Editing comment " + comment.getText());
    }

    public String getComment(Comment comment) {
        LOGGER.info("Getting comment " + comment.getText());
        return comment.getText();
    }
}
