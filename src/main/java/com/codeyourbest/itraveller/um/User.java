package com.codeyourbest.itraveller.um;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phone;

    private User (){}

    public User(@NonNull String name,
                @NonNull String surname,
                @NonNull String email,
                @NonNull String phone) {

        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }
}
