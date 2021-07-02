package com.cg.onlinesweetmartapplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlinesweetmartapplicationApplication {

	private static final Logger logger = LoggerFactory.getLogger(OnlinesweetmartapplicationApplication.class);
	public static void main(String[] args) {
		
		logger.info("Online Sweet Mart Application Initiated");
		SpringApplication.run(OnlinesweetmartapplicationApplication.class, args);
		System.out.println("Service started at port 8081");
	}

}
