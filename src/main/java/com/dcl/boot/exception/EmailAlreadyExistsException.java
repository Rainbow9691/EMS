package com.dcl.boot.exception;

public class EmailAlreadyExistsException extends RuntimeException {

	private String error ;

	public EmailAlreadyExistsException(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}
	
}
