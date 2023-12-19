package com.android.ecommerce.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class ApiExceptionHandler {

	@Autowired
	private MessageSource errormessage;

	/**
	 * Créer un payload qui contiendra tout les détails de l'exception
	 * @param exception
	 * @return l'entité réponse 
	 */
	@ExceptionHandler(value = {ApiRequestException.class})
	public ResponseEntity<Object> handleApiRequestException(ApiRequestException exception){
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		ApiException apiException = new ApiException(
				exception.getMessage(), 
				badRequest, 
				ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(apiException, badRequest);
	}



	@ExceptionHandler(value = {EntityNotFoundException.class})
	public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException exception){
		HttpStatus notFound = HttpStatus.NOT_FOUND;
		ApiException apiException = new ApiException(
				errormessage.getMessage("error.notFound", new Object[]{exception.getMessage()},  
						LocaleContextHolder.getLocale()),
				notFound, 
				ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(apiException, notFound);
	}
}
