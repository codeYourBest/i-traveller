package com.codeyourbest.itraveller.domain.idm.pub;

import com.codeyourbest.itraveller.domain.idm.RoleEnum;
import com.codeyourbest.itraveller.domain.idm.persistance.Role;
import com.codeyourbest.itraveller.domain.idm.persistance.User;

public class UserUtils {
    private UserUtils(){
        throw new AssertionError("Not istantiable");
    }

    public static User createBasicUser(String email) {

        return new User(
                "firstName",
                "lastName",
                email,
                "secret",
                true
        );
    }

    public static User createUserFromForm(SignupForm signupForm) {
        User user = new User(
                signupForm.getName(),
                signupForm.getLastName(),
                signupForm.getEmail(),
                signupForm.getPassword(),
                true);

        user.getRoles().add(new Role(RoleEnum.USER));
        return user;
    }
}
