package com.orange.repository;

import com.orange.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Karim on 7/17/2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void testGetByName() {
        User user = new User();
        user.setName("test");
        userRepository.save(user);
        List<User> userList = userRepository.getByName("test");
        assertTrue(userList != null && userList.size() != 0);
    }
}
