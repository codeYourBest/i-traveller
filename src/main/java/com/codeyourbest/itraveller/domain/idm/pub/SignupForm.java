package com.codeyourbest.itraveller.domain.idm.pub;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class SignupForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

}
