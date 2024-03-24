package com.employee.management.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleDataNotFoundException(final HttpServletRequest request,
			DataNotFoundException exception) {
		
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setError(exception.getMessage());
		error.setPath(request.getRequestURI());
		error.setTimeStamp(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
