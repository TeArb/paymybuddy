package com.paymybuddy.paymybuddy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication/*(exclude = {SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class})*/
public class PayMyBuddyApplication {

	private static final Logger logger = LogManager.getLogger("PayMyBuddyApplication");

	public static void main(String[] args) {
		try {
			SpringApplication.run(PayMyBuddyApplication.class, args);
			logger.info("Pay My Buddy starts");
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
