package com.example.demo.project.mapper;
import com.example.demo.project.domain.ProjectRequest;
import com.example.demo.project.domain.ProjectsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
@Mapper(componentModel = "spring")
@Component
public interface ProjectMapper {
//    @Mapping(source = "null", target = "name")
//    ProjectsEntity reqToEntity(ProjectRequest projectRequest);

}


