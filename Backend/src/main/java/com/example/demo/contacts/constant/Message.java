package com.example.demo.contacts.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Message {
    CONTACTS_SAVED_SUCCESSFULLY("Contacts saved successfully"),
    CONTACTS_SAVED_FAILED("Contacts saved failed");
    private final String message;
}
