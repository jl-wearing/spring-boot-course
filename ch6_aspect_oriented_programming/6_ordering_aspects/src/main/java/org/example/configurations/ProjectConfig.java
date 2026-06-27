package org.example.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "org.example")
@EnableAspectJAutoProxy
public class ProjectConfig {
}
