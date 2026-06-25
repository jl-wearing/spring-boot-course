package config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import models.Penguin;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"repositories", "services"})
public class ProjectConfig {

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Penguin penguin() {
        Penguin penguin = new Penguin();
        penguin.setName("Kowalski");
        return penguin;
    }
}
