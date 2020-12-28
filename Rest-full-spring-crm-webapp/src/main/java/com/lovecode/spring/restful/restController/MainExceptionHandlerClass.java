package com.lovecode.spring.restful.restController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MainExceptionHandlerClass {

	@ExceptionHandler
	public ResponseEntity<CustomerExceptionResponse> singleException(CustomerRestException cre)
	{
		CustomerExceptionResponse cer=new CustomerExceptionResponse();
		cer.setStatus(HttpStatus.NOT_FOUND.value());
		cer.setMessage(cre.getMessage());
		cer.setTimeStanmp(System.currentTimeMillis());
		
		
		return new ResponseEntity(cer,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerExceptionResponse> singleException(Exception cre)
	{
		CustomerExceptionResponse cer=new CustomerExceptionResponse();
		cer.setStatus(HttpStatus.BAD_REQUEST.value());
		cer.setMessage(cre.getMessage());
		cer.setTimeStanmp(System.currentTimeMillis());
		
		return new ResponseEntity(cer,HttpStatus.BAD_REQUEST);
	}
	
	
}
