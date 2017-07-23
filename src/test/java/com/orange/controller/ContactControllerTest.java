package com.orange.controller;

import com.orange.entity.Contact;
import com.orange.entity.ContactDao;
import com.orange.entity.User;
import com.orange.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Karim on 7/13/2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = ContactController.class, secure = false)
public class ContactControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactController contactController;

    @MockBean
    private UserService userService;

    @Test
    public void testGetContactsByName() throws Exception {
        List<Contact> contactList = new ArrayList<>();
        Contact contact = new Contact();
        contact.setId(1);
        contact.setName("Karim");
        contact.setNumber("01112208496");
        User user = new User();
        user.setId(1);
        user.setName("testMockUser");
        contact.setUser(user);
        contactList.add(contact);
        String result = "[{\"id\": 1,\"name\": \"Karim\",\"number\":\"01112208496\"}]";
        Mockito.when(contactController.getContactsByName("Karim")).thenReturn(contactList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/contactByName/Karim");
        MvcResult response = mockMvc.perform(requestBuilder).andReturn();
        JSONAssert.assertEquals(result, response.getResponse().getContentAsString(), false);
    }

    @Test
    public void testGetContactsByNum() throws Exception {
        List<Contact> contactList = new ArrayList<>();
        Contact contact = new Contact();
        contact.setId(1);
        contact.setName("Karim");
        contact.setNumber("01112208496");
        User user = new User();
        user.setId(1);
        user.setName("testMockUser");
        contact.setUser(user);
        contactList.add(contact);
        String result = "[{\"id\": 1,\"name\": \"Karim\",\"number\":\"01112208496\"}]";
        Mockito.when(contactController.getContactsByNumber("01112208496")).thenReturn(contactList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/contactByNum/01112208496");
        MvcResult response = mockMvc.perform(requestBuilder).andReturn();
        JSONAssert.assertEquals(result, response.getResponse().getContentAsString(), false);
    }

    @Test
    public void testGetContactsByUserId() throws Exception {
        List<Contact> contactList = new ArrayList<>();
        Contact contact = new Contact();
        contact.setId(1);
        contact.setName("Karim");
        contact.setNumber("01112208496");
        User user = new User();
        user.setId(1);
        user.setName("testMockUser");
        contact.setUser(user);
        contactList.add(contact);
        String result = "[{\"id\": 1,\"name\": \"Karim\",\"number\": \"01112208496\"}]";
        Mockito.when(contactController.getContactsByUserId(1)).thenReturn(contactList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/contactByUser/1");
        MvcResult response = mockMvc.perform(requestBuilder).andReturn();
        JSONAssert.assertEquals(result, response.getResponse().getContentAsString(), false);
    }

    @Test
    public void testGetContactById() throws Exception {
        Contact contact = new Contact();
        contact.setId(1);
        contact.setName("Karim");
        contact.setNumber("01112208496");
        User user = new User();
        user.setId(1);
        user.setName("testMockUser");
        contact.setUser(user);
        String result = "{\"id\": 1,\"name\": \"Karim\",\"number\": \"01112208496\"}";
        Mockito.when(contactController.getContactById(1)).thenReturn(contact);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/contactById/1");
        MvcResult response = mockMvc.perform(requestBuilder).andReturn();
        JSONAssert.assertEquals(result, response.getResponse().getContentAsString(), false);
    }

    @Test
    public void testUpdateContact() throws Exception {
        ContactDao contactDao = new ContactDao();
        contactDao.setName("Karim");
        contactDao.setNumber("01112208496");
        String contactDaoJson = "{\"name\":\"Karim\",\"number\":\"01112208496\"}";
        String result = "{\"status:\":\"success\"}";
        Mockito.when(contactController.updateContact(1, contactDao)).thenReturn(result);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/updateContact/1").content(contactDaoJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult response = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(result, response.getResponse().getContentAsString());
    }

    @Test
    public void testSaveContacts() throws Exception {
        ContactDao contactDao = new ContactDao();
        contactDao.setName("Karim");
        contactDao.setNumber("01112208496");
        String contactDaoJson = "[{\"name\":\"Karim\",\"number\":\"01112208496\"}]";
        User user = new User();
        user.setId(1);
        user.setName("testMockUser");
        String result = "{\"status:\":\"success\"}";
        List<ContactDao> contactDaoList = new ArrayList<>();
        contactDaoList.add(contactDao);
        Mockito.when(contactController.saveContacts(1, contactDaoList)).thenReturn(result);
        Mockito.when(userService.getUserById(1)).thenReturn(user);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/saveContacts/1").content(contactDaoJson)
                .contentType(MediaType.APPLICATION_JSON);
        ;
        MvcResult response = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(result, response.getResponse().getContentAsString());
    }
}

