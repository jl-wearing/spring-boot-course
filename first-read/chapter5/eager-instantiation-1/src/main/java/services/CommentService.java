package services;

import org.springframework.stereotype.Service;

@Service
public class CommentService {
    public CommentService() {
        System.out.println("Comment Service created via eager instantiation.");
    }
}
