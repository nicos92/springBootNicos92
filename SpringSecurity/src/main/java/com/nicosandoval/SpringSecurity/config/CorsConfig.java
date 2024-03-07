package com.nicosandoval.SpringSecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry){
        corsRegistry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS","PATCH")
                .allowedHeaders("Origin", "Content-Type", "Accept", "Authorization")
                .allowCredentials(true)
                .maxAge(3600);

        corsRegistry.addMapping("/auth/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS","PATCH")
                .allowedHeaders("Origin", "Content-type", "Accept", "Authorization")
                .allowCredentials(false)
                .maxAge(3600);
    }
}
