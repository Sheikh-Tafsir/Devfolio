package com.example.demo.about.controller;

import com.example.demo.about.domain.AboutEntity;
import com.example.demo.about.domain.AboutRequest;
import com.example.demo.about.domain.AboutResponse;
import com.example.demo.about.domain.AboutViewRequest;
import com.example.demo.about.service.AboutService;
import com.example.demo.project.domain.ProjectRequest;
import com.example.demo.project.domain.ProjectResponse;
import com.example.demo.project.domain.ProjectsEntity;
import com.example.demo.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/about")
public class AboutController {
    private final AboutService aboutService;
    @PostMapping("/create")
    public AboutResponse create(@RequestBody AboutRequest aboutRequest) {
        return aboutService.create(aboutRequest);
    }

    @PostMapping("/viewpersonal")
    public AboutEntity viewPersonal(@RequestBody AboutViewRequest aboutViewRequest){
        return aboutService.viewPersonal(aboutViewRequest);
    }

    @GetMapping("viewall")
    public List<AboutEntity> viewAll(){
        return aboutService.viewAll();
    }
}
