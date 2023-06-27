package com.example.demo.about.service;

import com.example.demo.about.domain.AboutEntity;
import com.example.demo.about.domain.AboutRequest;
import com.example.demo.about.domain.AboutResponse;
import com.example.demo.about.domain.AboutViewRequest;
import com.example.demo.project.domain.ProjectsEntity;

import java.util.List;

public interface AboutService {
    AboutResponse create(AboutRequest aboutRequest);
    List<AboutEntity> viewAll();
    AboutEntity viewPersonal(AboutViewRequest aboutViewRequest);
}
