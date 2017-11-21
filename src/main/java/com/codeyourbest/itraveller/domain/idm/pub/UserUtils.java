package com.codeyourbest.itraveller.domain.idm.pub;

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
                "111222333",
                "secret",
                true
        );
    }

}
