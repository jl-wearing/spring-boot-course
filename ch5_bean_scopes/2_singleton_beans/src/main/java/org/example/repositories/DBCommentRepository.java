package org.example.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class DBCommentRepository implements CommentRepository {
    @Override
    public void storeData() {
        System.out.println("Storing comments");
    }
}
