package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.demo.common.config"})
//@ComponentScan(basePackages = "com.example.demo.project.mapper")
public class Demo6Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo6Application.class, args);
    }

}
