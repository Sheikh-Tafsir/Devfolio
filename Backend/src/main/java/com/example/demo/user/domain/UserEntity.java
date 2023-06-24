package com.example.demo.user.domain;
import com.example.demo.about.domain.AboutEntity;
import com.example.demo.common.domain.BaseEntity;
import com.example.demo.contacts.domain.ContactsEntity;
import com.example.demo.project.domain.ProjectsEntity;
import com.example.demo.service.domain.ServiceEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="users",schema = "public")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;


    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AboutEntity> about = new ArrayList<>();
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ServiceEntity> service = new ArrayList<>();
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectsEntity> projects = new ArrayList<>();
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContactsEntity> contacts= new ArrayList<>();

    public UserEntity(String name,String email, String password){
        this.name=name;
        this.email=email;
        this.password=password;
    }

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true)
//    private AboutEntity aboutEntity;

}
