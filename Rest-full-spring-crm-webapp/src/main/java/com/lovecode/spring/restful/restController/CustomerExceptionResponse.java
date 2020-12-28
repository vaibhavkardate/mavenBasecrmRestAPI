package com.lovecode.spring.restful.restController;

public class CustomerExceptionResponse {
	
 private 	int status;
 
 private String message;
 private long timeStanmp;
public CustomerExceptionResponse(int status, String message, long timeStanmp) {
	super();
	this.status = status;
	this.message = message;
	this.timeStanmp = timeStanmp;
}
public CustomerExceptionResponse() {
	super();
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public long getTimeStanmp() {
	return timeStanmp;
}
public void setTimeStanmp(long timeStanmp) {
	this.timeStanmp = timeStanmp;
}

}
