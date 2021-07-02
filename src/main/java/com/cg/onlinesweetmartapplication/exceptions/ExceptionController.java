package com.cg.onlinesweetmartapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleProductNotFoundException(ProductNotFoundException exception)
	{
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(exception.getMessage());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.OK);
	}
	
	@ExceptionHandler(InvalidProductDetailsException.class)
	public ResponseEntity<ErrorMessage> handleInvalidProductDetailsException(InvalidProductDetailsException exception)
	{
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage(exception.getMessage());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(CartNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleCartNotFoundException(CartNotFoundException exception)
	{
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(exception.getMessage());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.OK);
	}
	@ExceptionHandler(InvalidCartDetailsException.class)
	public ResponseEntity<ErrorMessage> handleInvalidCartDetailsException(InvalidCartDetailsException exception)
	{
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage(exception.getMessage());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidOrderBillDetailsException.class)
	public ResponseEntity<ErrorMessage> handleInvalidOrderBillDetailsException(InvalidOrderBillDetailsException exception)
	{
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage(exception.getMessage());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidSweetItemDetailsException.class)
	public ResponseEntity<ErrorMessage> handleInvalidSweetItemDetailsException(InvalidSweetItemDetailsException exception)
	{
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage(exception.getMessage());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidSweetOrderInputException.class)
	public ResponseEntity<ErrorMessage> handleInvalidSweetOrderInputException(InvalidSweetOrderInputException exception)
	{
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage(exception.getMessage());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidUsersDetailsException.class)
	public ResponseEntity<ErrorMessage> handleInvalidUsersDetailsException(InvalidUsersDetailsException exception)
	{
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage(exception.getMessage());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OrderBillNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleOrderBillNotFoundException(OrderBillNotFoundException exception)
	{
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage(exception.getMessage());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SweetItemNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleSweetItemNotFoundException(SweetItemNotFoundException exception)
	{
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage(exception.getMessage());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SweetOrderNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleSweetOrderNotFoundException(SweetOrderNotFoundException exception)
	{
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage(exception.getMessage());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleUserNotFoundException(UserNotFoundException exception)
	{
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage(exception.getMessage());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
	}
}