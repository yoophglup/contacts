package com.methodindustries.contacts.repository;

import com.methodindustries.contacts.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
    public Optional<Contact> findById(Long id);
    Contact save(Contact c);

}
