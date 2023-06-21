package com.example.demo.project.domain;

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
public class ProjectRequest implements Serializable {

    private Long userId;
    private String name;
    private String description;
    private String technologies;
    private String category;
    private String liveLink;
    private String gitLink;
    private String imageLink;

}
