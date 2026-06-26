package org.example.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"org.example.aspects", "org.example.services"})
@EnableAspectJAutoProxy
public class ProjectConfig {
}
