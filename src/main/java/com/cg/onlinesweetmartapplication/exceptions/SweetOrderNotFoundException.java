package com.cg.onlinesweetmartapplication.exceptions;

public class SweetOrderNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	public SweetOrderNotFoundException() {
		super();
	}
	
	public SweetOrderNotFoundException(String message) {
		super(message);
	}
	
}
