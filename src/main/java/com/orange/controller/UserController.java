package com.orange.controller;

import com.orange.entity.User;
import com.orange.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Karim on 7/10/2017.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/userById/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/userByName/{name}", method = RequestMethod.GET)
    public List<User> getUserByName(@PathVariable("name") String name) {
        return userService.getUsersByName(name);
    }

    @RequestMapping(value = "/addUser/{name}", method = RequestMethod.POST)
    public String addUser(@PathVariable("name") String name) {
        userService.addUser(name);
        return "{\"status\":\"success\"}";
    }
}
