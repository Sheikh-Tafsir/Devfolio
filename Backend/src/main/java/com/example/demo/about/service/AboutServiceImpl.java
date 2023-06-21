package com.example.demo.about.service;

import com.example.demo.about.domain.AboutEntity;
import com.example.demo.about.domain.AboutRequest;
import com.example.demo.about.domain.AboutResponse;
import com.example.demo.about.repository.AboutRepository;
import com.example.demo.project.domain.ProjectsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.example.demo.about.constant.Message.ABOUT_SAVED_FAILED;
import static com.example.demo.about.constant.Message.ABOUT_SAVED_SUCCESSFULLY;


@Service
@RequiredArgsConstructor
public class AboutServiceImpl implements AboutService{
    private final AboutRepository aboutRepository;


    @Override
    public AboutResponse create(@RequestBody AboutRequest aboutRequest) {

        AboutEntity aboutEntity = new AboutEntity(
                aboutRequest.getUserId(),
                aboutRequest.getOccupation(),
                aboutRequest.getDescription(),
                aboutRequest.getBackgroundImageLink(),
                aboutRequest.getAboutImageLink()
        );

        try{
            aboutRepository.save(aboutEntity);
            return new AboutResponse(ABOUT_SAVED_SUCCESSFULLY.getMessage());
        }
        catch (Exception e){
            return new AboutResponse(ABOUT_SAVED_FAILED.getMessage());
        }
    }
    @Override
    public List<AboutEntity> viewAll(){
        List<AboutEntity> aboutList=aboutRepository.findAll();
        return aboutList;
    }
}
