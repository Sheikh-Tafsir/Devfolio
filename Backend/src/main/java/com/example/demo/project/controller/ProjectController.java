package com.example.demo.project.controller;

import com.example.demo.common.controller.ApiResponse;
import com.example.demo.common.controller.ResponseUtil;
import com.example.demo.project.domain.ProjectRequest;
import com.example.demo.project.domain.ProjectResponse;
import com.example.demo.project.domain.ProjectsEntity;
import com.example.demo.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.project.constant.Message.PROJECTS_FOUND;

@CrossOrigin(origins="*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

//    public ProjectResponse create(@RequestBody ProjectRequest projectRequest) {
//        return projectService.create(projectRequest);
//    }
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<ProjectResponse>> create(@RequestBody ProjectRequest projectRequest) {
        ProjectResponse projectResponse = projectService.create(projectRequest);
        return ResponseUtil.createResponse(HttpStatus.CREATED, projectResponse.getResponseMessage(),null);
    }
    @GetMapping("viewall")
    public ResponseEntity<ApiResponse<List<ProjectsEntity>>>viewAll(){
        List<ProjectsEntity>projectList = projectService.viewAll();
        return ResponseUtil.createResponse(HttpStatus.OK,PROJECTS_FOUND.getMessage(),projectList);
    }
}
