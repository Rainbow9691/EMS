package com.dcl.boot.exception;

public class NoEmployeeObjectFoundException extends RuntimeException {

	private String error;

	public String getError() {
		return error;
	}

	public NoEmployeeObjectFoundException(String string) {
		error = string;
	}

	public String getMessage() {
		return error;
	}

}
