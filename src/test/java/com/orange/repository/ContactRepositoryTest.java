package com.orange.repository;

import com.orange.entity.Contact;
import com.orange.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

/**
 * Created by Karim on 7/17/2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ContactRepositoryTest {
    @Autowired
    ContactRepository contactRepository;

    @Autowired
    UserRepository userRepository;

    Contact contact;
    User user;

    @Before
    public void init() {
        contact = new Contact();
        contact.setName("test contact");
        contact.setNumber("0112208496");
        user = new User();
        user.setName("test user");
        userRepository.save(user);
        contact.setUser(user);
        contactRepository.save(contact);
    }

    @Test
    public void testGetByName() {
        assertTrue(contactRepository.getByName("test contact") != null);
    }

    @Test
    public void testGetByNumber() {
        assertTrue(contactRepository.getByNumber("0112208496") != null);
    }

    @Test
    public void testGetByUserId() {
        assertTrue(contactRepository.getByUserId(user.getId()) != null);
    }
}
