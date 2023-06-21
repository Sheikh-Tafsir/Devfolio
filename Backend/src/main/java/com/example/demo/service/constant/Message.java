package com.example.demo.service.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Message {
    SERVICE_SAVED_SUCCESSFULLY("Service saved successfully"),
    SERVICE_SAVE_FAILED("Service save failed");
    private final String message;
}
