package com.example.demo.user.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public enum Message {
    USER_FOUND("user found"),
    USER_DONT_EXIST("user don't exist"),
    LOGIN_SUCCESSFUL("Login successful"),
    SIGNUP_SUCCESSFUL("Signup successful"),
    NAME_ALREADY_TAKEN("Name already taken");
    private final String message;
}
