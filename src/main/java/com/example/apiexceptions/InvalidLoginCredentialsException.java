package com.example.apiexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * RuntimeException child class which should be thrown to return a '401' status code from API 
 * 
 * This class should not be modified
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class InvalidLoginCredentialsException extends RuntimeException {
	public InvalidLoginCredentialsException(String message) {
		super(message);
	}
}
