package com.example.demo.about.repository;

import com.example.demo.about.domain.AboutEntity;
import com.example.demo.project.domain.ProjectsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AboutRepository extends JpaRepository<AboutEntity,Long> {

    AboutEntity findByUserId(Long userId);
}
