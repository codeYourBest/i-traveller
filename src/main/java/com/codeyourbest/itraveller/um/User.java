package com.codeyourbest.itraveller.um;

import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

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
    @NotEmpty(message = "*Please provide username")
    private String username;

    @Column(nullable = false)
    @NotEmpty(message = "*Please provide surname")
    private String surname;

    @Column(nullable = false)
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;

    private String phone;

    @Column(nullable = false)
    @Transient
    private String password;

    private boolean enabled = true;

    /*@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;*/

    private User (){}

    public User(@NonNull String username,
                @NonNull String surname,
                @NonNull String email,
                @NonNull String phone,
                @NonNull String password,
                boolean enabled) {

        this.username = username;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.enabled = enabled;
    }
}
