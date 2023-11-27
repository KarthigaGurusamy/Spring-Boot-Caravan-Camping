package com.restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    private final Environment environment;

    public CorsConfig(Environment environment) {
        this.environment = environment;
    }
    @Bean
    WebMvcConfigurer configurer() {
        return new WebMvcConfigurer() {
            String location = environment.getProperty("app.file.storage.mapping");

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
//                registry.addResourceHandler("/uploads/**")
//                        .addResourceLocations(location);
//                registry.addResourceHandler("/resources/**")
//                        .addResourceLocations("C:/Users/kumaran/Documents/Java/Spring-Boot-Caravan-Camping/src/main/resources");
            }

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("*");
            }
        };
    }
}

