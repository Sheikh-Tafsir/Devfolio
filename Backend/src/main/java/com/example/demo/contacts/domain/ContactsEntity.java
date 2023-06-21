package com.example.demo.contacts.domain;

import com.example.demo.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="contacts",schema = "public")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContactsEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String phoneNo;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String facebookLink;

    @Column(nullable = false)
    private String instagramLink;

    @Column(nullable = false)
    private String githubLink;

    @Column(nullable = false)
    private String linkedinLink;

    public ContactsEntity(Long userId, String phoneNo, String email, String facebookLink, String instagramLink, String githubLink, String linkedinLink) {
        this.userId = userId;
        this.phoneNo = phoneNo;
        this.email = email;
        this.facebookLink = facebookLink;
        this.instagramLink = instagramLink;
        this.githubLink = githubLink;
        this.linkedinLink = linkedinLink;
    }
}
