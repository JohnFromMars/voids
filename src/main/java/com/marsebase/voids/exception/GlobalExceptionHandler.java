package com.marsebase.voids.exception;

import java.util.concurrent.TimeoutException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private Logger log = LogManager.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(TimeoutException.class)
	@ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
	public void handleTimeoutException(TimeoutException e){
		log.error(e);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
	public void hadleException(Exception e){
		log.error(e);
	}

}
