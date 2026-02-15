package com.orderpayment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import com.orderpayment.response.ErrorResponse;

@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity< ErrorResponse> handleUserNotFoundException(UserNotFoundException e) {
		
			return new ResponseEntity<ErrorResponse>(
					new ErrorResponse(HttpStatus.NOT_FOUND.value()
							, e.getMessage()),HttpStatus.NOT_FOUND);
		
	}
}
