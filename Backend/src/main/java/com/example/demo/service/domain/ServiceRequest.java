package com.example.demo.service.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ServiceRequest implements Serializable {
    private Long userId;
    private String name;
    private String description;
}
