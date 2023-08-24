package com.harshrathore.finalproject.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.harshrathore.finalproject.service.BikeNotFoundException;
@ControllerAdvice
public class ErrorLogic extends ResponseEntityExceptionHandler {
	@ExceptionHandler(BikeNotFoundException.class)
	public final ResponseEntity<Object> handleBikeNotFoundException(Exception ex, WebRequest request) throws Exception{
		ErrorDetails er = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object> (er,HttpStatus.NOT_FOUND);
	}
	
	
}
