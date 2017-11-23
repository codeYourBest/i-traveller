package com.codeyourbest.itraveller.domain.idm.pub;

import com.codeyourbest.itraveller.domain.idm.persistance.Role;
import com.codeyourbest.itraveller.domain.idm.persistance.User;
import com.codeyourbest.itraveller.domain.idm.repositories.RoleRepository;
import com.codeyourbest.itraveller.domain.idm.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createUser(User user, Set<Role> userRoles) {

        for (Role userRole : userRoles) {
            roleRepository.save(userRole);
        }
        user.getRoles().addAll(userRoles);
        user = userRepository.save(user);

        return user;
    }
}
