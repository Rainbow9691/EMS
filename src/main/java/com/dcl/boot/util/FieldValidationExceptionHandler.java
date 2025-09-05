package com.dcl.boot.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class FieldValidationExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<Map<String,String>> errorDetails = new ArrayList<Map<String,String>>();
		List<FieldError> fieldErrors = ex.getFieldErrors();
		
		for(FieldError error : fieldErrors) {
			Map<String,String> fieldDetails = new HashMap<String,String>();
			fieldDetails.put(" Field ",error.getField());
			fieldDetails.put(" message ",error.getDefaultMessage());
			errorDetails.add(fieldDetails);
		}
		
		ErrorStructure<List<Map<String,String>>> er = new ErrorStructure<List<Map<String,String>>>();
		er.setErrorCode(HttpStatus.CONFLICT.value());
		er.setMessage("Field validation failed");
		er.setError(errorDetails);
		
		return new ResponseEntity<Object>(er,HttpStatus.CONFLICT);
	}
	
	
}
