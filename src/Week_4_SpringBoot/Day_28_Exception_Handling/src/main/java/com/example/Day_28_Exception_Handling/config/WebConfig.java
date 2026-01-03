package com.example.Day_28_Exception_Handling.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow all endpoints
                .allowedOrigins("http://localhost:5173") // Allow React
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow these actions
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
