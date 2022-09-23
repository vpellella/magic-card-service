package com.infy.magiccard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CardDrawingException extends Exception {

	public CardDrawingException(String message) {
		super(message);
	}
	
}
