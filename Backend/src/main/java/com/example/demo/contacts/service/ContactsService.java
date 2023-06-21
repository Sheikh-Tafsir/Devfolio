package com.example.demo.contacts.service;

import com.example.demo.contacts.domain.ContactsEntity;
import com.example.demo.contacts.domain.ContactsRequest;
import com.example.demo.contacts.domain.ContactsResponse;

import java.util.List;

public interface ContactsService {
    ContactsResponse create(ContactsRequest contactsRequest);

    List<ContactsEntity> viewAll();
}
