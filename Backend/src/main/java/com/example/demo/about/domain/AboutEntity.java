package com.example.demo.about.domain;

import com.example.demo.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="about",schema = "public")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AboutEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String occupation;

    @Column(nullable = false)
    private String description;

    @Column(nullable = true)
    private String backgroundImageLink;
    @Column(nullable = false)
    private String aboutImageLink;

    public AboutEntity(Long userId, String occupation, String description, String backgroundImageLink, String aboutImageLink) {
        this.userId = userId;
        this.occupation = occupation;
        this.description = description;
        this.backgroundImageLink = backgroundImageLink;
        this.aboutImageLink = aboutImageLink;
    }
}
