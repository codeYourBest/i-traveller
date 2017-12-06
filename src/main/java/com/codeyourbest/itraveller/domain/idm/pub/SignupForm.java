package com.codeyourbest.itraveller.domain.idm.pub;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SignupForm {

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NotNull
    @Size(min=6, max=30)
    private String password;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String lastName;

}
