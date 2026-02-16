package com.orderpayment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import com.orderpayment.response.ErrorResponse;

import io.swagger.v3.oas.annotations.Hidden;

@ControllerAdvice
@Hidden
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity< ErrorResponse> handleUserNotFoundException(UserNotFoundException e) {
		
			return new ResponseEntity<ErrorResponse>(
					new ErrorResponse(HttpStatus.NOT_FOUND.value()
							, e.getMessage()),HttpStatus.NOT_FOUND);
		
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException e){
		return new ResponseEntity<ErrorResponse>(
				new ErrorResponse(HttpStatus.NOT_FOUND.value()
						, e.getMessage()),HttpStatus.NOT_FOUND);
	}
}
