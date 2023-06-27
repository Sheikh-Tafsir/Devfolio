package com.example.demo.about.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AboutViewRequest implements Serializable {
    private Long userId;
}
