package com.orange.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Karim on 7/10/2017.
 */
@Entity
@Table(name = "users", schema = "test_schema")
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = "contactSet")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    private String name;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Contact> contactSet = new HashSet<>();
}
