package com.cg.onlinesweetmartapplication.exceptions;

public class InvalidCartDetailsException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidCartDetailsException() {
		super();
	}
	
	public InvalidCartDetailsException(String message)
	{
		super(message);
	}

}