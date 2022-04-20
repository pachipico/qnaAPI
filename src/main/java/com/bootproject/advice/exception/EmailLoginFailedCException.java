package com.bootproject.advice.exception;

import lombok.extern.slf4j.Slf4j;

public class EmailLoginFailedCException extends RuntimeException {
	public EmailLoginFailedCException() {
		super();
	}
	
	public EmailLoginFailedCException(String message) {
		super(message);
	}
	
	public EmailLoginFailedCException(String message, Throwable cause) {
		super(message, cause);
	}
	
	
}
