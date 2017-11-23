package com.codeyourbest.itraveller.domain.idm.persistance;

import com.codeyourbest.itraveller.domain.idm.RoleEnum;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
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
    private Set<User> users = new HashSet<>();

    private Role(){};

    public Role(RoleEnum role) {
        this.name = role.getRoleName();
    }
}
