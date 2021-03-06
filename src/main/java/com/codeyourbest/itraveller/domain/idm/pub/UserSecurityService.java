package com.codeyourbest.itraveller.domain.idm.pub;

import com.codeyourbest.itraveller.domain.idm.persistance.User;
import com.codeyourbest.itraveller.domain.idm.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("Username " + username + "not found");
        }
        return user;
    }
}
