package com.example.demo.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//public class CorsConfig {
//
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("https://hoppscotch.io/,", "http://localhost:8080", "http://localhost:3000") // Replace with your allowed origin(s)
//                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Specify the allowed HTTP methods
//                        .allowedHeaders("*") // Specify the allowed headers
//                        .allowCredentials(true); // Enable credentials (if needed)
//            }
//        };
//    }
//}


