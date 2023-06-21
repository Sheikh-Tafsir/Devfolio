package com.example.demo.about.domain;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AboutRequest implements Serializable {
    private Long userId;
    private String occupation;
    private String description;
    private String backgroundImageLink;
    private String aboutImageLink;
}
