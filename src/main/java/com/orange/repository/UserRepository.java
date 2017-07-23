package com.orange.repository;

import com.orange.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Karim on 7/10/2017.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    public List<User> getByName(String name);
}
