package services;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy(true)
public class CommentService {
    public CommentService() {
        System.out.println("CommentService instance created!");
    }
}
