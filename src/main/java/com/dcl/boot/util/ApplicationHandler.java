package com.dcl.boot.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dcl.boot.exception.EmailAlreadyExistsException;
import com.dcl.boot.exception.EmployeeObjectNotFoundByIdException;
import com.dcl.boot.exception.EmployeeObjectNotFoundByNameException;
import com.dcl.boot.exception.NoEmployeeObjectFoundException;
import com.dcl.boot.exception.PhoneNumberAlreadyExistsException;

@RestControllerAdvice
public class ApplicationHandler {
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleEmployeeNotFoundById(EmployeeObjectNotFoundByIdException nf) {
		ErrorStructure<String> es = new ErrorStructure<String>();
		es.setErrorCode(HttpStatus.NOT_FOUND.value());
		es.setMessage(nf.getMessage());
		es.setError("Employee object with the requested id not available in the database");

		return new ResponseEntity<ErrorStructure<String>>(es, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handelEmployeeNotFoundByName(
			EmployeeObjectNotFoundByNameException nf) {
		ErrorStructure<String> es = new ErrorStructure<String>();

		es.setErrorCode(HttpStatus.NOT_FOUND.value());
		es.setMessage(nf.getMessage());
		es.setError("Employee object for the requested name is not found in the database");

		return new ResponseEntity<ErrorStructure<String>>(es, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handelNoEmployeeObjectFoundException(
			NoEmployeeObjectFoundException nf) {
		ErrorStructure<String> es = new ErrorStructure<String>();

		es.setErrorCode(HttpStatus.NOT_FOUND.value());
		es.setMessage(nf.getMessage());
		es.setError("No Employee object found in the database");

		return new ResponseEntity<ErrorStructure<String>>(es, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handelEmailAlreadyExistsException(EmailAlreadyExistsException nf) {
		ErrorStructure<String> es = new ErrorStructure<String>();

		es.setErrorCode(HttpStatus.CONFLICT.value());
		es.setMessage(nf.getError());
		es.setError("Email already exists in the database");

		return new ResponseEntity<ErrorStructure<String>>(es, HttpStatus.CONFLICT);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handlePhoneNumberAlreadyExistsException(
			PhoneNumberAlreadyExistsException nf) {
		ErrorStructure<String> es = new ErrorStructure<String>();

		es.setErrorCode(HttpStatus.CONFLICT.value());
		es.setMessage(nf.getError());
		es.setError("Phone nummber already exists in the database");

		return new ResponseEntity<ErrorStructure<String>>(es, HttpStatus.CONFLICT);
	}

}
