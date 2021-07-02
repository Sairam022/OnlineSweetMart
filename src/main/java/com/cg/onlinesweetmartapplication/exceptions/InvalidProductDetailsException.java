package com.cg.onlinesweetmartapplication.exceptions;

public class InvalidProductDetailsException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidProductDetailsException() {
		super();
	}
	
	public InvalidProductDetailsException(String message)
	{
		super(message);
	}

}
