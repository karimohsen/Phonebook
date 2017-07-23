package com.orange.controller;

import com.orange.entity.Contact;
import com.orange.entity.ContactDao;
import com.orange.entity.User;
import com.orange.services.ContactService;
import com.orange.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karim on 7/10/2017.
 */
@RestController
@RequestMapping(value = "/contacts")
public class ContactController {

    @Autowired
    ContactService contactService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/contactByName/{name}", method = RequestMethod.GET)
    public List<Contact> getContactsByName(@PathVariable("name") String name) {
        return contactService.getContactsByName(name);
    }

    @RequestMapping(value = "/contactByNum/{number}", method = RequestMethod.GET)
    public List<Contact> getContactsByNumber(@PathVariable("number") String number) {
        return contactService.getContactsByNumber(number);
    }

    @RequestMapping(value = "/contactByUser/{userId}", method = RequestMethod.GET)
    public List<Contact> getContactsByUserId(@PathVariable("userId") int id) {
        return contactService.getContactsByUserId(id);
    }

    @RequestMapping(value = "/contactById/{contactId}", method = RequestMethod.GET)
    public Contact getContactById(@PathVariable("contactId") int id) {
        return contactService.getContact(id);
    }

    @RequestMapping(value = "/updateContact/{contactId}", method = RequestMethod.PUT)
    public String updateContact(@PathVariable("contactId") int id, @RequestBody ContactDao contactDao) {
        Contact contact = new Contact();
        contact.setId(id);
        contact.setName(contactDao.getName());
        contact.setNumber(contactDao.getNumber());
        contact.setUser(contactService.getContact(id).getUser());
        contactService.updateContact(contact);

        return "{\"status:\":\"success\"}";
    }


    @RequestMapping(value = "/saveContacts/{userId}", method = RequestMethod.POST)
    public String saveContacts(@PathVariable("userId") int id, @RequestBody List<ContactDao> contactDaoList) {
        List<Contact> contactList = new ArrayList<>();
        User user = userService.getUserById(id);
        for (int i = 0; i < contactDaoList.size(); i++) {
            Contact contact = new Contact();
            contact.setName(contactDaoList.get(i).getName());
            contact.setNumber(contactDaoList.get(i).getNumber());
            contact.setUser(user);
            contactList.add(contact);
        }
        contactService.saveAllContact(contactList);
        return "{\"status:\":\"success\"}";
    }
}
