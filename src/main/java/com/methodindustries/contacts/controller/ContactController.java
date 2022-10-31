package com.methodindustries.contacts.controller;

import com.methodindustries.contacts.model.Contact;
import com.methodindustries.contacts.model.ContactDTO;
import com.methodindustries.contacts.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {

    @Autowired
    ContactService contactService;

    @RequestMapping(method = RequestMethod.GET, value= "/contact/{id}")
    public Contact readContact(@PathVariable Long id){
        return contactService.getContact(id);
    }



    @RequestMapping(method = RequestMethod.POST, value="/contact",consumes = "application/json")
    public  Contact create(@RequestBody ContactDTO contactDTO){
       Contact c = contactService.mapper(contactDTO);
       Contact contact = contactService.create(c);
       return contact;

    }
    @RequestMapping(method = RequestMethod.PUT, value = "/contact/{id}", consumes ="application/json")
    public Contact update(@PathVariable Long id, @RequestBody ContactDTO contactDTO){
        Contact c = contactService.getContact(id);
        Contact contact = contactService.update(c, contactDTO);
        return contact;
    }
    @RequestMapping(method= RequestMethod.DELETE, value = "/contact/{id}")
    public String deleteContact(@PathVariable Long id){
        contactService.delete(id);
        return "Contact Delete";
    }

}
