package com.cg.onlinesweetmartapplication.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinesweetmartapplication.entities.User;
import com.cg.onlinesweetmartapplication.exceptions.UserNotFoundException;
import com.cg.onlinesweetmartapplication.model.UserDTO;
import com.cg.onlinesweetmartapplication.service.iUserService;
import com.cg.onlinesweetmartapplication.serviceImpl.UserServiceImpl;



@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/osm")
public class UserController {
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	iUserService service;
	
	@PostMapping(value = "/user/add" , consumes = "application/json")
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		logger.info("add-User URL is opened");
		logger.info("addUser() is initiated");
		Object result;
		HttpStatus status;
		if (!UserServiceImpl.validateUserId(user)) {
			result = "Invalid userId.";
			status = HttpStatus.BAD_REQUEST;
		}
		else if (!UserServiceImpl.validateUserName(user)) {
			result = "Invalid userName.";
			status = HttpStatus.BAD_REQUEST;
		}
		else if (!UserServiceImpl.validatePassword(user)) {
			result = "Invalid password.";
			status = HttpStatus.BAD_REQUEST;
		}
		else if (!UserServiceImpl.validatePasswordConfirm(user))
		{
			result= "Password confirm failed";
			status= HttpStatus.BAD_REQUEST;
		}
		else if (!user.getPassword().equals(user.getPasswordConfirm()))
		{
			result= "Passwords don't match";
			status= HttpStatus.BAD_REQUEST;
		}
		else if (!UserServiceImpl.validateType(user)) {
			result = "Invalid type.";
			status = HttpStatus.BAD_REQUEST;
		}
		else {
			result = service.addUser(user);
			status = HttpStatus.OK;
		}
		logger.info("addUser() has executed");
		return new ResponseEntity<Object>(result,status);
	} 
		
	
	
	@PutMapping(value= "/user/update" , consumes = "application/json")
	public ResponseEntity<Object> updateUser(@RequestBody User user) throws UserNotFoundException
	{
		logger.info("update-User URL is opened");
		logger.info("updateUser() is initiated");
		Object result;
		HttpStatus status;
		if (!UserServiceImpl.validateUserId(user)) {
			result = "Invalid userId.";
			status = HttpStatus.BAD_REQUEST;
		}
		else if (!UserServiceImpl.validateUserName(user)) {
			result = "Invalid userName.";
			status = HttpStatus.BAD_REQUEST;
		}
		else if (!UserServiceImpl.validatePassword(user)) {
			result = "Invalid password.";
			status = HttpStatus.BAD_REQUEST;
		}
		else if (!UserServiceImpl.validatePasswordConfirm(user))
		{
			result= "Password confirm failed";
			status= HttpStatus.BAD_REQUEST;
		}
		else if (!user.getPassword().equals(user.getPasswordConfirm()))
		{
			result= "Passwords don't match";
			status= HttpStatus.BAD_REQUEST;
		}
		else if (!UserServiceImpl.validateType(user)) {
			result = "Invalid type.";
			status = HttpStatus.BAD_REQUEST;
		}
		else {
			result = service.updateUser(user);
			status = HttpStatus.OK;
		}
		logger.info("updateUser() has executed");
		return new ResponseEntity<Object>(result,status);
		
	}

	
	@DeleteMapping(value= "/user/cancel/{userId}")
	public ResponseEntity<Object> cancelUser(@PathVariable ("userId") long userId) throws UserNotFoundException
	{
		logger.info("cancel-Usert URL is opened");
		logger.info("cancelUser() is initiated");
		Object result;
		HttpStatus status;
		if (userId < 0) {
			result = "Invalid userId.";
			status = HttpStatus.BAD_REQUEST;
		}
		else {
			result = service.cancelUser(userId);
			status = HttpStatus.OK;
		}
		logger.info("cancelUser() has executed");
		return new ResponseEntity<Object> (result,status);
	}
	
	
	
	@GetMapping(value="/user/show/{id}" , produces="application/json")
	public UserDTO showUser(@PathVariable("id") long  userId) throws UserNotFoundException{
		logger.info("show-UserURL is opened");
		logger.info("showUser() is initiated");
		logger.info("showUser() has executed");
		return service.showUser(userId);
		
	}
	
	
	@GetMapping(value="/user/show-all" , produces="application/json")
	public List<UserDTO> showAllUsers()
	{
		logger.info("show-All-Users URL is opened");
		logger.info("showAllUsers() is initiated");
		return service.showAllUsers();
	}
	
	
	
}
