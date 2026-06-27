package org.example.services;

import org.example.aspects.logging.ToLog;
import org.example.models.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    public void publishComment(Comment comment) {
        System.out.println("Publishing comment: " + comment.getText());
    }

    @ToLog
    public void deleteComment(Comment comment) {
        System.out.println("Deleting comment: " + comment.getText());
    }
}
