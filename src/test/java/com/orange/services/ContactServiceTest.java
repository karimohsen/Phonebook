package com.orange.services;

import com.orange.entity.Contact;
import com.orange.entity.User;
import com.orange.repository.ContactRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Karim on 7/16/2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ContactServiceTest {

    @MockBean
    ContactRepository contactRepository;

    ContactService contactService;

    Contact contact;

    List<Contact> contactList;

    @Before
    public void init() {
        contactService = mock(ContactService.class);
        contact = new Contact();
        contact.setName("con");
        contact.setId(1);
        contact.setNumber("312312");
        User user = new User();
        user.setName("abbas");
        user.setId(1);
        contact.setUser(user);
        contactList = new ArrayList<>();
        contactList.add(contact);
    }

    @Test
    public void testGetContactsByName() {
        when(contactService.getContactsByName("con")).thenReturn(contactList);
        when(contactRepository.getByName("con")).thenReturn(contactList);
        assertTrue(contactRepository.getByName("con").size() != 0);
    }

    @Test
    public void testGetContactsByNumber() {
        when(contactService.getContactsByNumber("312312")).thenReturn(contactList);
        when(contactRepository.getByNumber("312312")).thenReturn(contactList);
        assertTrue(contactRepository.getByNumber("312312").size() != 0);
    }

    @Test
    public void testGetContactsByUserId() {
        when(contactService.getContactsByUserId(1)).thenReturn(contactList);
        when(contactRepository.getByUserId(1)).thenReturn(contactList);
        assertTrue(contactRepository.getByUserId(1).size() != 0);
    }


}
