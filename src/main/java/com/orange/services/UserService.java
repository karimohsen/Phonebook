package com.orange.services;

import com.orange.entity.User;
import com.orange.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Karim on 7/10/2017.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(int id) {
        return userRepository.findOne(id);
    }


    public List<User> getUsersByName(String name) {
        return userRepository.getByName(name);
    }

    public void addUser(String name) {
        User user = new User();
        user.setName(name);
        userRepository.save(user);
    }

}
