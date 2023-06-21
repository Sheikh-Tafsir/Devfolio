package com.example.demo.contacts.controller;

import com.example.demo.contacts.domain.ContactsEntity;
import com.example.demo.contacts.domain.ContactsRequest;
import com.example.demo.contacts.domain.ContactsResponse;
import com.example.demo.contacts.service.ContactsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/contacts")
public class ContactsController {
    private final ContactsService contactsService;
    @PostMapping("/create")
    public ContactsResponse create(@RequestBody ContactsRequest contactsRequest) {
        return contactsService.create(contactsRequest);
    }
    @GetMapping("viewall")
    public List<ContactsEntity> viewAll(){
        return contactsService.viewAll();
    }
}
