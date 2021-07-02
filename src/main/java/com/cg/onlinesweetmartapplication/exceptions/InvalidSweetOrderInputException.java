package com.cg.onlinesweetmartapplication.exceptions;

public class InvalidSweetOrderInputException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidSweetOrderInputException() {
		super();
	}
	
	public InvalidSweetOrderInputException(String message)
	{
		super(message);
	}

}
