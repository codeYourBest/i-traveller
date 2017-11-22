package com.codeyourbest.itraveller.domain.idm.pub;

import com.codeyourbest.itraveller.domain.idm.RoleEnum;
import com.codeyourbest.itraveller.domain.idm.persistance.Role;
import com.codeyourbest.itraveller.domain.idm.persistance.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void createNewUser() throws Exception {
        User user = createUser("test.UserServiceTest.createNewUser.@gmail.com");

        Assert.assertNotNull(user);
        Assert.assertNotEquals(0, user.getId());
    }

    private User createUser(String email) {
        User user = UserUtils.createBasicUser(email);
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(new Role(RoleEnum.USER));

        user = userService.createUser(user, userRoles);
        return user;
    }
}