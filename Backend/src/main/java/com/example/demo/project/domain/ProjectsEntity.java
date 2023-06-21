package com.example.demo.project.domain;
import com.example.demo.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="projects",schema = "public")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProjectsEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String technologies;

    @Column(nullable = false)
    private String category;

    @Column(nullable = true)
    private String liveLink;

    @Column(nullable = true)
    private String gitLink;
    @Column(nullable = false)
    private String imageLink;

    public ProjectsEntity(Long userId, String name, String description, String technologies, String category, String liveLink, String gitLink, String imageLink) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.technologies = technologies;
        this.category = category;
        this.liveLink = liveLink;
        this.gitLink = gitLink;
        this.imageLink = imageLink;
    }

}
