package org.example;

import org.example.models.Comment;
import org.example.proxies.EmailCommentNotificationProxy;
import org.example.repositories.DBCommentRepository;
import org.example.services.CommentService;

public class App {
    public static void main( String[] args ) {
        var commentRepository = new DBCommentRepository();
        var commentNotificationProxy = new EmailCommentNotificationProxy();

        // Define the service of publishing a comment.
        var commentService = new CommentService(commentRepository, commentNotificationProxy);

        // Define a comment to be published.
        Comment comment = new Comment();
        comment.setAuthor("Laurentiu Spilca");
        comment.setText("The Spring Context: Using Abstractions");

        // Publish the comment.
        commentService.publishComment(comment);
    }
}
