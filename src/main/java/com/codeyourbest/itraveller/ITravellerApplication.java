package com.codeyourbest.itraveller;

import com.codeyourbest.itraveller.domain.idm.persistance.Role;
import com.codeyourbest.itraveller.domain.idm.persistance.User;
import com.codeyourbest.itraveller.domain.idm.pub.UserService;
import com.codeyourbest.itraveller.domain.idm.pub.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ITravellerApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	private static final Logger LOG = LoggerFactory.getLogger(ITravellerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ITravellerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String email = "klaskoski@gmail.com";
		User user = UserUtils.createBasicUser(email);
		Set<Role> userRoles = new HashSet<>();
		userRoles.add(new Role("admin"));

		userService.createUser(user, userRoles);
		LOG.info("created user {}", user);
	}
}
