package com.japolo;
import models.Parrot;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Initialize the Spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Get the bean from the context.
        var bean = context.getBean(Parrot.class);
        System.out.println(bean.getName());
    }
}