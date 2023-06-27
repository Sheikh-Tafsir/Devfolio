package com.example.demo.about.service;

import com.example.demo.about.domain.AboutEntity;
import com.example.demo.about.domain.AboutRequest;
import com.example.demo.about.domain.AboutResponse;
import com.example.demo.about.domain.AboutViewRequest;
import com.example.demo.about.mapper.AboutMapper;
import com.example.demo.about.repository.AboutRepository;
import com.example.demo.project.domain.ProjectsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.example.demo.about.constant.Message.*;


@Service
@RequiredArgsConstructor
public class AboutServiceImpl implements AboutService{
    private final AboutRepository aboutRepository;
    @Override
    public AboutResponse create(@RequestBody AboutRequest aboutRequest) {

        AboutEntity aboutEntitySrc= aboutRepository.findByUserId(aboutRequest.getUserId());

        try{
            if(aboutEntitySrc == null) {
                AboutEntity aboutEntity = new AboutEntity(
                        aboutRequest.getUserId(),
                        aboutRequest.getOccupation(),
                        aboutRequest.getDescription(),
                        aboutRequest.getBackgroundImageLink(),
                        aboutRequest.getAboutImageLink()
                );
                aboutRepository.save(aboutEntity);
                return new AboutResponse(ABOUT_SAVED_SUCCESSFULLY.getMessage());
            }
            else{
                aboutEntitySrc.setOccupation(aboutRequest.getOccupation());
                aboutEntitySrc.setDescription(aboutRequest.getDescription());
                aboutEntitySrc.setBackgroundImageLink(aboutRequest.getBackgroundImageLink());
                aboutEntitySrc.setAboutImageLink(aboutRequest.getAboutImageLink());
                aboutRepository.save(aboutEntitySrc);
                return new AboutResponse(ABOUT_UPDATED_SUCCESSFULLY.getMessage());
            }

        }
        catch (Exception e) {
            return new AboutResponse(ABOUT_SAVED_FAILED.getMessage());
        }
    }

    @Override
    public AboutEntity viewPersonal(AboutViewRequest aboutViewRequest){
        return aboutRepository.findByUserId(aboutViewRequest.getUserId());
    }
    @Override
    public List<AboutEntity> viewAll(){
        List<AboutEntity> aboutList=aboutRepository.findAll();
        return aboutList;
    }
}
