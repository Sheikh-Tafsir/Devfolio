package com.example.demo.project.service;

import com.example.demo.project.domain.ProjectRequest;
import com.example.demo.project.domain.ProjectResponse;
import com.example.demo.project.domain.ProjectsEntity;

import java.util.List;

public interface ProjectService {
    ProjectResponse create(ProjectRequest projectRequest);
    List<ProjectsEntity> viewAll();
}
