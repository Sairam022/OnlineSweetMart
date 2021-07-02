package com.cg.onlinesweetmartapplication.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinesweetmartapplication.entities.User;
import com.cg.onlinesweetmartapplication.exceptions.UserNotFoundException;
import com.cg.onlinesweetmartapplication.repository.iUserRepository;
import com.cg.onlinesweetmartapplication.service.ILoginService;


@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	iUserRepository repository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);
	private static final String MESSAGE_INVALID_ID = "Invalid user id.";
	
	@Override
	public boolean login(long userId, String password) throws UserNotFoundException {
		boolean result;
		LOGGER.info("login service method is initiated.");
		User user = repository.findById(userId).orElse(null);
		if (user == null) {
			LOGGER.error(MESSAGE_INVALID_ID);
			throw new UserNotFoundException(MESSAGE_INVALID_ID);
		}
		else {
			String correctPassword = user.getPassword();
			if (correctPassword == null) {
				result =  false;
			}
			else {
				if (correctPassword.equals(password)) {
					user.setLoggedIn(true);
					repository.save(user);
					result = true;
				}
				else {
					result = false;
				}
			}
			
			
		}
		LOGGER.info("login service method is terminated.");
		return result;
	}

	
	@Override
	public boolean logout(long userId) throws UserNotFoundException {
		LOGGER.info("logout service method is initiated.");
		boolean result;
		User user = repository.findById(userId).orElse(null);
		if (user == null) {
			LOGGER.error(MESSAGE_INVALID_ID);
			throw new UserNotFoundException(MESSAGE_INVALID_ID);
		}
		else {
			user.setLoggedIn(false);
			repository.save(user);
			result = true;
		}	
		LOGGER.info("logout service method is terminated.");
		return result;
	}

	
	@Override
	public boolean isLoggedIn(long userId) throws UserNotFoundException {
		LOGGER.info("isLoggedIn service method is initiated.");
		boolean result;
		User user = repository.findById(userId).orElse(null);
		if (user == null) {
			LOGGER.error(MESSAGE_INVALID_ID);
			throw new UserNotFoundException(MESSAGE_INVALID_ID);
		}
		else {
			result = user.isLoggedIn();
		}	
		LOGGER.info("isLoggedIn service method is terminated.");
		return result;
	}
	
	
	
	//Validation for userId of the user.
	public static boolean validateUserId(long userId) {
		LOGGER.info("User id validation is performed.");
		return userId > 0;
	}
	
	
	
	//Validation for the password
	public static boolean validateLoginPassword(String password) {
		LOGGER.info("Password validation is performed.");
		return password != null && password.matches(".*[@#$%^&+=].*") && password.matches(".*[a-z].*") && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*") && password.length() >= 8;
	}

}
