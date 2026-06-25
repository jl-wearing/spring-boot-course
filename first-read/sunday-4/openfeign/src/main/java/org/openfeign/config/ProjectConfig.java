package org.openfeign.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;

@EnableFeignClients(basePackages = "org.openfeign.proxies")
@Component
public class ProjectConfig {
}
