package org.example.__openfeign.configurations;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = "org.example.__openfeign.proxies")
@Configuration
public class ProjectConfig {
}
