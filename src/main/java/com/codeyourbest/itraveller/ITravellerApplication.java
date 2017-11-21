package com.codeyourbest.itraveller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ITravellerApplication implements CommandLineRunner {
	private static final Logger LOG = LoggerFactory.getLogger(ITravellerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ITravellerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
