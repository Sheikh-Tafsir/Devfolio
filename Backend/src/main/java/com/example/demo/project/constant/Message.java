package com.example.demo.project.constant;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Message {
    PROJECT_SAVED_SUCCESSFULLY("Project saved successfully"),
    PROJECT_SAVED_FAILED("Project saved failed"),
    PROJECTS_FOUND("projects found");
    private final String message;
}
