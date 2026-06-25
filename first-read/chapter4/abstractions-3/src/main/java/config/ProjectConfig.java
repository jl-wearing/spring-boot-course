package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"proxies", "repositories", "services"})
// You can also specify specific classes using the basePackageClasses attribute.
public class ProjectConfig {
}
