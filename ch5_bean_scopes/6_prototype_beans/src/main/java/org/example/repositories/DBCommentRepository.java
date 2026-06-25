package org.example.repositories;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Repository
public class DBCommentRepository implements CommentRepository {
    @Override
    public void storeComment() {
        System.out.println("Storing comment");
    }
}
