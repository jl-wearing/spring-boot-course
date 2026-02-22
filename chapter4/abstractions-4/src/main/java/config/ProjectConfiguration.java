package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import models.Comment;
import proxies.*;
import repositories.*;
import services.CommentService;

@Configuration
public class ProjectConfiguration {
    @Bean
    public CommentRepository commentRepository() {
        return new DBCommentRepository();
    }

    @Bean
    public CommentNotificationProxy commentNotificationProxy() {
        return new EmailCommentNotificationProxy();
    }

    @Bean
    public CommentService commentService(
            CommentRepository commentRepository,
            CommentNotificationProxy commentNotificationProxy)
    {
        return new CommentService(commentRepository, commentNotificationProxy);
    }
}
