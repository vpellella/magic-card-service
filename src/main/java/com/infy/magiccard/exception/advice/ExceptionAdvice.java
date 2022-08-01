package com.infy.magiccard.exception.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.infy.magiccard.exception.CardDrawingException;

@ControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler
	public ResponseEntity handleCardDrawingException(CardDrawingException ex) {
		Map<String, Object> resp = new HashMap();
		resp.put("excepton", "CardDrawingException");
		resp.put("description", ex.getMessage());
		resp.put("longDescriptione", ex.toString());
		resp.put("statusCode", HttpStatus.BAD_REQUEST.value());

		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.contentType(MediaType.APPLICATION_JSON)
				.body(resp);
	}
}
