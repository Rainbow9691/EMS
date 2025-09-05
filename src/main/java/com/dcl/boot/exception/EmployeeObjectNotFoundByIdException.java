package com.dcl.boot.exception;

public class EmployeeObjectNotFoundByIdException extends RuntimeException {

	private String error;

	public String getError() {
		return error;
	}

	public EmployeeObjectNotFoundByIdException(String string) {
		error = string;
	}

	public String getMessage() {
		return error;
	}

}
