package com.orange.repository;

import com.orange.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Karim on 7/10/2017.
 */
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    public List<Contact> getByName(String name);

    public List<Contact> getByNumber(String number);

    public List<Contact> getByUserId(int id);
}
