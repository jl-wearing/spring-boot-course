package org.example.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "org.example.models")
public class ProjectConfig {
}
