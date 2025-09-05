package com.dcl.boot.exception;

public class PhoneNumberAlreadyExistsException extends RuntimeException {

	private String error;

	public PhoneNumberAlreadyExistsException(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}

}
