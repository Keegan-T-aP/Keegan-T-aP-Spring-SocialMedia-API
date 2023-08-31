package com.example.apiexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * RuntimeException child class which should be thrown to return a '400' status code from API 
 * 
 * This class should not be modified
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MessageCreationUnsuccessfulException extends RuntimeException {
	public MessageCreationUnsuccessfulException(String message) {
		super(message);
	}
}
