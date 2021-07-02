package com.cg.onlinesweetmartapplication.service;

import java.util.List;

import com.cg.onlinesweetmartapplication.entities.User;
import com.cg.onlinesweetmartapplication.exceptions.UserNotFoundException;
import com.cg.onlinesweetmartapplication.model.UserDTO;

public interface iUserService {

	public UserDTO addUser(User user);

	public UserDTO updateUser(User user) throws UserNotFoundException;

	public UserDTO cancelUser(long userId) throws UserNotFoundException;//Changed the data type of argument to long because the data type of User's userId attribute is Long. 

	public List<UserDTO> showAllUsers();
	
	public UserDTO showUser(long  userId) throws UserNotFoundException;
}
