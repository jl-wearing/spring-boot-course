package org.example.services;

import org.example.aspects.ToLog;
import org.example.models.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {
    private static final Logger LOGGER =  Logger.getLogger(CommentService.class.getName());

    @ToLog
    public String publishComment(Comment comment) {
        LOGGER.info("Publishing comment: " + comment);
        return "SUCCESS";
    }
}
