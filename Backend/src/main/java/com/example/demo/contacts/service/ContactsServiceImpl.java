package com.example.demo.contacts.service;

import com.example.demo.contacts.domain.ContactsEntity;
import com.example.demo.contacts.domain.ContactsRequest;
import com.example.demo.contacts.domain.ContactsResponse;
import com.example.demo.contacts.repository.ContactsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


import static com.example.demo.contacts.constant.Message.CONTACTS_SAVED_FAILED;
import static com.example.demo.contacts.constant.Message.CONTACTS_SAVED_SUCCESSFULLY;

@Service
@RequiredArgsConstructor
public class ContactsServiceImpl implements ContactsService{

    private final ContactsRepository contactsRepository;
    @Override
    public ContactsResponse create(ContactsRequest contactsRequest){
        ContactsEntity contactsEntity = new ContactsEntity(
                contactsRequest.getUserId(),
                contactsRequest.getPhoneNo(),
                contactsRequest.getEmail(),
                contactsRequest.getFacebookLink(),
                contactsRequest.getInstagramLink(),
                contactsRequest.getGithubLink(),
                contactsRequest.getLinkedinLink()
        );

        try{
            contactsRepository.save(contactsEntity);
            return new ContactsResponse(CONTACTS_SAVED_SUCCESSFULLY.getMessage());
        }
        catch (Exception e){
            return new ContactsResponse(CONTACTS_SAVED_FAILED.getMessage());
        }
    }
    @Override
    public List<ContactsEntity> viewAll(){
        return contactsRepository.findAll();
    }
}
