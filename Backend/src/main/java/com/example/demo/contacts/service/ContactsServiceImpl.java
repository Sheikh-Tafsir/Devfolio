package com.example.demo.contacts.service;

import com.example.demo.contacts.domain.ContactsEntity;
import com.example.demo.contacts.domain.ContactsRequest;
import com.example.demo.contacts.domain.ContactsResponse;
import com.example.demo.contacts.domain.ContactsViewRequest;
import com.example.demo.contacts.repository.ContactsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


import static com.example.demo.contacts.constant.Message.*;

@Service
@RequiredArgsConstructor
public class ContactsServiceImpl implements ContactsService{

    private final ContactsRepository contactsRepository;
    @Override
    public ContactsResponse create(ContactsRequest contactsRequest){
        ContactsEntity contactsEntitySrc= contactsRepository.findByUserId(contactsRequest.getUserId());

        try {
            if (contactsEntitySrc == null) {
                ContactsEntity contactsEntity = new ContactsEntity(
                        contactsRequest.getUserId(),
                        contactsRequest.getPhoneNo(),
                        contactsRequest.getEmail(),
                        contactsRequest.getFacebookLink(),
                        contactsRequest.getInstagramLink(),
                        contactsRequest.getGithubLink(),
                        contactsRequest.getLinkedinLink()
                );
                contactsRepository.save(contactsEntity);
                return new ContactsResponse(CONTACTS_SAVED_SUCCESSFULLY.getMessage());
            }
            else {
                contactsEntitySrc.setPhoneNo(contactsRequest.getPhoneNo());
                contactsEntitySrc.setEmail(contactsRequest.getEmail());
                contactsEntitySrc.setFacebookLink(contactsRequest.getFacebookLink());
                contactsEntitySrc.setInstagramLink(contactsRequest.getInstagramLink());
                contactsEntitySrc.setGithubLink(contactsRequest.getGithubLink());
                contactsEntitySrc.setLinkedinLink(contactsRequest.getLinkedinLink());
                contactsRepository.save(contactsEntitySrc);
                return new ContactsResponse(CONTACTS_UPDATED_SUCCESSFULLY.getMessage());
            }
        }
        catch (Exception e){
            return new ContactsResponse(CONTACTS_SAVED_FAILED.getMessage());
        }
    }

    @Override
    public ContactsEntity viewPersonal(ContactsViewRequest contactsViewRequest){
        return contactsRepository.findByUserId(contactsViewRequest.getUserId());
    }

    @Override
    public List<ContactsEntity> viewAll(){
        return contactsRepository.findAll();
    }
}
