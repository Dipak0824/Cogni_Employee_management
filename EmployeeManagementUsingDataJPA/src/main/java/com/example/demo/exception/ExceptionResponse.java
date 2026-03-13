package com.example.demo.exception;

import java.time.LocalDate;

public class ExceptionResponse {
private String errorMessage;
private LocalDate timeOfException;
private int statusCode;
public String getErrorMessage() {
	return errorMessage;
}
public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}
public LocalDate getTimeOfException() {
	return timeOfException;
}
public void setTimeOfException(LocalDate timeOfException) {
	this.timeOfException = timeOfException;
}
public int getStatusCode() {
	return statusCode;
}
public void setStatusCode(int statusCode) {
	this.statusCode = statusCode;
}
public ExceptionResponse() {
	super();
}
public ExceptionResponse(String errorMessage, LocalDate timeOfException, int statusCode) {
	super();
	this.errorMessage = errorMessage;
	this.timeOfException = timeOfException;
	this.statusCode = statusCode;
}

}
