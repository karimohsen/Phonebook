package com.orange.services;

import com.orange.entity.Contact;
import com.orange.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Karim on 7/10/2017.
 */
@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public List<Contact> getContactsByName(String name) {
        return contactRepository.getByName(name);
    }

    public List<Contact> getContactsByNumber(String number) {
        return contactRepository.getByNumber(number);
    }

    public List<Contact> getContactsByUserId(int id) {
        return contactRepository.getByUserId(id);
    }

    public void updateContact(Contact contact) {
        contactRepository.save(contact);
    }

    public Contact getContact(int contactId) {
        return contactRepository.findOne(contactId);
    }

    public void saveAllContact(List<Contact> contactList) {
        contactRepository.save(contactList);

    }
}
