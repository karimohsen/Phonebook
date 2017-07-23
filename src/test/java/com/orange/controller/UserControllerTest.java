package com.orange.controller;

import com.orange.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Karim on 7/13/2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserController userController;

    @Test
    public void testAddUser() throws Exception {
        String result = "{\"status\":\"success\"}";
        Mockito.when(userController.addUser("testMockUser")).thenReturn(result);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addUser/testMockUser");
        MvcResult response = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(result, response.getResponse().getContentAsString());
    }

    @Test
    public void testGetUserByName() throws Exception {
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setName("testMockUser");
        user.setContactSet(new HashSet<>());
        userList.add(user);
        String result = "[{\"id\":1,\"name\":\"testMockUser\",\"contactSet\":[]}]";
        Mockito.when(userController.getUserByName("testMockUser")).thenReturn(userList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/userByName/testMockUser");
        MvcResult response = mockMvc.perform(requestBuilder).andReturn();
        JSONAssert.assertEquals(result, response.getResponse().getContentAsString(), false);
    }

    @Test
    public void testGetUserById() throws Exception {
        User user = new User();
        user.setId(1);
        user.setName("testMockUser");
        user.setContactSet(new HashSet<>());
        String result = "{\"id\":1,\"name\":\"testMockUser\",\"contactSet\":[]}";
        Mockito.when(userController.getUserById(1)).thenReturn(user);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/1");
        MvcResult response = mockMvc.perform(requestBuilder).andReturn();
        JSONAssert.assertEquals(result, response.getResponse().getContentAsString(), false);
    }
}
