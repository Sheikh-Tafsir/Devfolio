package com.example.demo.about.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Message {
    ABOUT_SAVED_SUCCESSFULLY("About saved successfully"),
    ABOUT_UPDATED_SUCCESSFULLY("About updated successfully"),
    ABOUT_SAVED_FAILED("About saved failed");

    private final String message;
}
