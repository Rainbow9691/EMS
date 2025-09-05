package com.dcl.boot.exception;

public class EmployeeObjectNotFoundByNameException extends RuntimeException {

	private String error;

	public String getError() {
		return error;
	}

	public EmployeeObjectNotFoundByNameException(String string) {
		error = string;
	}

	public String getMessage() {
		return error;
	}

}
