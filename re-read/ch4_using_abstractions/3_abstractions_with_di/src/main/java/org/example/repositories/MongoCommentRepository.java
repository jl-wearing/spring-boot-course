package org.example.repositories;

import org.example.models.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("nosql")
public class MongoCommentRepository implements CommentRepository{
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment in mongo-db: " + comment.getText());
    }
}
