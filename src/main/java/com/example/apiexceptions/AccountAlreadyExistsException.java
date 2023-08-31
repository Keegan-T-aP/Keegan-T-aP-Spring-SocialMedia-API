package com.example.apiexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * RuntimeException child class which should be thrown to return a '409' status code from API 
 * 
 * This class should not be modified
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class AccountAlreadyExistsException extends RuntimeException {
	public AccountAlreadyExistsException(String message) {
		super(message);
	}
}


