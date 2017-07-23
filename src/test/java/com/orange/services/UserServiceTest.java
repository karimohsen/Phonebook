package com.orange.services;

import com.orange.entity.User;
import com.orange.repository.UserRepository;
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
public class UserServiceTest {

    @MockBean
    UserRepository userRepository;

    UserService userService;

    @Before
    public void init() {
        userService = mock(UserService.class);
    }

    @Test
    public void testGetUserById() {
        User user = new User();
        user.setName("abbas");
        user.setId(1);
        when(userRepository.findOne(1)).thenReturn(user);
        when(userService.getUserById(1)).thenReturn(user);
        User tempUser = userService.getUserById(1);
        assertTrue(tempUser.getName().equals("abbas"));
    }

    @Test
    public void testGetUserByName() {
        User user = new User();
        user.setName("abbas");
        user.setId(1);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.getByName("abbas")).thenReturn(userList);
        when(userService.getUsersByName("abbas")).thenReturn(userList);
        List<User> tempUserList = userService.getUsersByName("abbas");
        assertTrue(tempUserList.size() != 0);
    }

}
