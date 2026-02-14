package com.shubham.exception;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(PoliticianResourseNotFound.class)
	public ResponseEntity<ErrorPage> customException(PoliticianResourseNotFound ex){
		ErrorPage e=new ErrorPage(ex.getMessage(),LocalTime.now(),HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(e,HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorPage> AllException(Exception ex){
		ErrorPage e=new ErrorPage(ex.getMessage(),LocalTime.now(),HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(e,HttpStatus.OK);
	}
	

}
