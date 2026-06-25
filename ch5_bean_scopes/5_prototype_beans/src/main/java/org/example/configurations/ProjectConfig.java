package org.example.configurations;

import org.example.services.CommentService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ProjectConfig {
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Bean
    public CommentService commentService() {
        return new CommentService();
    }
}
