package com.example.demo.contacts.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContactsViewRequest implements Serializable {
    private Long userId;
}
