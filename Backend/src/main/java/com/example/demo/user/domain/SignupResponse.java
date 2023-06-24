package com.example.demo.user.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SignupResponse implements Serializable {
    private String respMessage;
    private String token;
    private Long id;
}