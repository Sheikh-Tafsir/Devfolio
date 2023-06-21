package com.example.demo.project.service;

import com.example.demo.project.domain.ProjectRequest;
import com.example.demo.project.domain.ProjectResponse;
import com.example.demo.project.domain.ProjectsEntity;
import com.example.demo.project.mapper.ProjectMapper;
import com.example.demo.project.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.example.demo.project.constant.Message.PROJECT_SAVED_FAILED;
import static com.example.demo.project.constant.Message.PROJECT_SAVED_SUCCESSFULLY;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService{
    private final ProjectRepository projectRepository;
    //private final ProjectMapper projectMapper;

    @Override
    public ProjectResponse create(@RequestBody ProjectRequest projectRequest) {

        //ProjectsEntity projectsEntity = projectMapper.reqToEntity(projectRequest);

        ProjectsEntity projectsEntity = new ProjectsEntity(
                projectRequest.getUserId(),
                projectRequest.getName(),
                projectRequest.getDescription(),
                projectRequest.getTechnologies(),
                projectRequest.getCategory(),
                projectRequest.getLiveLink(),
                projectRequest.getGitLink(),
                projectRequest.getImageLink()
        );

        try{
            projectRepository.save(projectsEntity);
            return new ProjectResponse(PROJECT_SAVED_SUCCESSFULLY.getMessage());
        }
        catch (Exception e){
            return new ProjectResponse(PROJECT_SAVED_FAILED.getMessage());
        }
    }
    @Override
    public List<ProjectsEntity> viewAll(){
        List<ProjectsEntity>projectList=projectRepository.findAll();
        return projectList;
    }

}
