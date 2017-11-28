package com.codeyourbest.itraveller.domain.idm.persistance;

import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Users")
public class User  implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    @NotEmpty(message = "*Please provide name")
    private String username;

    @Column(nullable = false)
    @NotEmpty(message = "*Please provide firstname")
    private String firstName;

    @Column(nullable = false)
    @NotEmpty(message = "*Please provide lastname")
    private String lastName;

    @Column(nullable = false)
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;

    private String phone;

    @Column(nullable = false)
    private String password;

    private boolean enabled = true;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    private User (){}

    public User(@NonNull String firstName,
                @NonNull String lastName,
                @NonNull String email,
                @NonNull String phone,
                @NonNull String password,
                boolean enabled) {

        this.username = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        roles.forEach(ur -> authorities.add(new Authority(ur.getName())));
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
