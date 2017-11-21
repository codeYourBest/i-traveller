package com.codeyourbest.itraveller.domain.security;

import com.codeyourbest.itraveller.domain.um.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "Roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
