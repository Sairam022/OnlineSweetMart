package com.cg.onlinesweetmartapplication.exceptions;

public class InvalidSweetItemDetailsException extends Exception {

		private static final long serialVersionUID = 1L;

		public InvalidSweetItemDetailsException() {
			super();
		}
		
		public InvalidSweetItemDetailsException(String message)
		{
			super(message);
		}


}
