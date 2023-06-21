package com.example.demo.contacts.domain;

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
public class ContactsRequest implements Serializable {
    private Long userId;
    private String phoneNo;
    private String email;
    private String facebookLink;
    private String instagramLink;
    private String githubLink;
    private String linkedinLink;
}
