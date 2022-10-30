package com.methodindustries.contacts.services;

import com.methodindustries.contacts.model.ContactDTO;
import com.methodindustries.contacts.repository.ContactRepository;
import com.methodindustries.contacts.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;
    public Contact getContact(Long id){
        Optional<Contact> c = contactRepository.findById(id);
        return c.get();
    }
    public Contact create(Contact c){
        return contactRepository.save(c);
    }
    public Contact mapper(ContactDTO dto){
        Contact c = new Contact();
        c.setFirstName(dto.getFirstName());
        c.setLastName(dto.getLastName());
        c.setStartDate(dto.getStartDate());
        c.setGender(dto.getGender());

        return c;
    }
}
