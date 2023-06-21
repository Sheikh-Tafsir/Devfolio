package com.example.demo.contacts.repository;

import com.example.demo.contacts.domain.ContactsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactsRepository extends JpaRepository<ContactsEntity,Long> {
}
