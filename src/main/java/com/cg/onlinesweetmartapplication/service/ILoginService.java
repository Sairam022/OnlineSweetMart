package com.cg.onlinesweetmartapplication.service;

import com.cg.onlinesweetmartapplication.exceptions.UserNotFoundException;

public interface ILoginService {
	boolean login(long userId,String password) throws UserNotFoundException;
	boolean logout(long userId) throws UserNotFoundException;
	boolean isLoggedIn(long userId) throws UserNotFoundException;
}
