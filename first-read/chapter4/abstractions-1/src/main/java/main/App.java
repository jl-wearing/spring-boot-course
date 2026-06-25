package main;

import proxies.*;
import services.*;
import repositories.*;
import models.*;

public class App {
    public static void main(String[] args) {
        // Implementing the use case to store the comment in a database.
        var commentRepository = new DBCommentRepository();

        // Implementing the use case to send the notification to an email.
        var commentNotificationProxy = new EmailCommentNotificationProxy();

        // Implementing the use case to publish a comment.
        var comment = new Comment();
        comment.setAuthor("Wearing");
        comment.setText("Demo comment");

        var commentService = new CommentService(commentRepository, commentNotificationProxy);
        commentService.publishComment(comment);
    }
}