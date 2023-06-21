package com.example.demo.user.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public enum Message {
    USER_FOUND("user found"),
    USER_DONT_EXIST("user don't exist"),

    LOGIN_SUCCESSFUL("Login successful");
    private final String message;
}
