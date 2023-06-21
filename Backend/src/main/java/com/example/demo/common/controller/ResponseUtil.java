package com.example.demo.common.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    public static <T> ResponseEntity<ApiResponse<T>> createResponse(HttpStatus status, String message, T data) {
        ApiResponse<T> apiResponse;
        if (message != null && data != null) {
            apiResponse = new ApiResponse<>(message, data);
        } else if (message != null) {
            apiResponse = new ApiResponse<>(message, null);
        } else if (data != null) {
            apiResponse = new ApiResponse<>(null, data);
        } else {
            apiResponse = new ApiResponse<>(null, null);
        }

        if (!apiResponse.hasData()) {
            apiResponse = new ApiResponse<>(message, null);
        }

        return ResponseEntity.status(status).body(apiResponse);
    }
}
