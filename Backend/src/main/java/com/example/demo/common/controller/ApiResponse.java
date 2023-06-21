package com.example.demo.common.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApiResponse<T> {
    //private int statusCode;
    private String message;
    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL) // Add this annotation
    public T getData() {
        return data;
    }

    public boolean hasData() {
        return data != null;
    }


    // Constructors, getters, and setters
}
