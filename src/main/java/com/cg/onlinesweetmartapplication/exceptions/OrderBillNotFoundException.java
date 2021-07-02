package com.cg.onlinesweetmartapplication.exceptions;

public class OrderBillNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
		
	public OrderBillNotFoundException() {
		super();
	}

	public OrderBillNotFoundException(String message) {
		super(message);
	}	
}