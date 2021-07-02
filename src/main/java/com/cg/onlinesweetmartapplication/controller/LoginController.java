package com.cg.onlinesweetmartapplication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinesweetmartapplication.entities.Login;
import com.cg.onlinesweetmartapplication.exceptions.UserNotFoundException;
import com.cg.onlinesweetmartapplication.service.ILoginService;
import com.cg.onlinesweetmartapplication.serviceImpl.LoginServiceImpl;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/osm")
public class LoginController {

	static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private ILoginService service;

	
	@PutMapping("/login")
	String login(@RequestBody Login login) throws UserNotFoundException{
		LOGGER.info("login URL is opened");
		LOGGER.info("login() is initiated");
		String response;
		Long userId = login.getUserId();
		String password = login.getPassword();
		if (LoginServiceImpl.validateUserId(userId) && LoginServiceImpl.validateLoginPassword(password)) {
			if (service.login(userId, password)) {
				response = "Login successful.";
			}
			else {
				response = "Login failed.";
			}
		}
		else {
			response = "Invalid input.";
		}
		LOGGER.info("login() has executed");
		return response;
	}
	
	@PutMapping("/logout/{userId}")
	String logout(@PathVariable("userId") long userId) throws UserNotFoundException{
		LOGGER.info("logout URL is opened");
		LOGGER.info("logout() is initiated");
		String response;
		if (LoginServiceImpl.validateUserId(userId)) {
			if (service.logout(userId)) {
				response = "Logout successful.";
			}
			else {
				response = "Logout failed.";
			}
		}
		else {
			response = "Invalid input.";
		}
		LOGGER.info("logout() has executed");
		return response;
	}

	
	@GetMapping("/is-loggedin/{userId}")
	String isLoggedIn(@PathVariable("userId") long userId) throws UserNotFoundException{
		LOGGER.info("isLoggedIn URL is opened");
		LOGGER.info("isLoggedIn() is initiated");
		String response;
		if (LoginServiceImpl.validateUserId(userId)) {
			if (service.isLoggedIn(userId)) {
				response = "User with id = "+userId+" is logged in.";
			}
			else {
				response = "User with id = "+userId+" is logged out.";
			}
		}
		else {
			response = "Invalid input.";
		}
		LOGGER.info("isLoggedIn() has executed");
		return response;
	}
	
}
