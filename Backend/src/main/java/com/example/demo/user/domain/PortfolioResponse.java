package com.example.demo.user.domain;

import com.example.demo.user.domain.UserEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PortfolioResponse implements Serializable {
    String responseMessage;
    UserEntity userEntity;
}
