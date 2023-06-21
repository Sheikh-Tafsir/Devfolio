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
public class ServiceResponse implements Serializable {
    String responseMessage;
}
