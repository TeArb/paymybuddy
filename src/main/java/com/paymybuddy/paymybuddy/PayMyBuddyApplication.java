package com.paymybuddy.paymybuddy;

import com.paymybuddy.paymybuddy.models.User;
import com.paymybuddy.paymybuddy.serviceImpl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class PayMyBuddyApplication implements CommandLineRunner {

	private static final Logger logger = LogManager.getLogger("PayMyBuddyApplication");

    @Autowired
    protected UserServiceImpl userService;

	public static void main(String[] args) {
		try {
			SpringApplication.run(PayMyBuddyApplication.class, args);
			logger.info("Pay My Buddy starts");
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

//		userService.getUsers().forEach(
//				user -> System.out.println(user.getFirstName()));
//
//		User newUser = new User();
//		newUser.setFirstName("Sean");
//		newUser.setLastName("Bean");
//		newUser.setBirthdate("15/06/1973");
//		newUser.setPhoneNumber("085208520");
//
//		userService.addUser(newUser);
//
//		userService.getUsers().forEach(
//				user -> System.out.println(user.getFirstName()));

	}
}
