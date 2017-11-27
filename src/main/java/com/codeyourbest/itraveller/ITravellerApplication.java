package com.codeyourbest.itraveller;

import com.codeyourbest.itraveller.domain.idm.RoleEnum;
import com.codeyourbest.itraveller.domain.idm.persistance.Role;
import com.codeyourbest.itraveller.domain.idm.persistance.User;
import com.codeyourbest.itraveller.domain.idm.pub.UserService;
import com.codeyourbest.itraveller.domain.idm.pub.UserUtils;
import com.codeyourbest.itraveller.domain.search.persistance.Connection;
import com.codeyourbest.itraveller.domain.search.repositories.ConnectionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ITravellerApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(ITravellerApplication.class);
    @Autowired
    private UserService userService;
    @Autowired
    private ConnectionRepository connectionRepository;

    public static void main(String[] args) {
        SpringApplication.run(ITravellerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String email = "klaskoski@gmail.com";
        User user = UserUtils.createBasicUser(email);
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(new Role(RoleEnum.ADMIN));

        userService.createUser(user, userRoles);

        Connection connection = new Connection("Krakow", "Katowice", Date.from(Instant.now()),
                Date.from(Instant.now().plusMillis(1000000000000L)));
        connectionRepository.save(connection);
        connection = new Connection("Tarnow", "Katowice", Date.from(Instant.now()),
                Date.from(Instant.now().plusMillis(1000000000000L)));
        connectionRepository.save(connection);
        connection = new Connection("Krakow", "Tarnow", Date.from(Instant.now()),
                Date.from(Instant.now().plusMillis(1000000000000L)));
        connectionRepository.save(connection);
        LOG.info("created user {}", user);
    }
}
