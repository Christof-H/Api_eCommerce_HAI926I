package com.android.ecommerce.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
@ControllerAdvice
public class ApiExceptionHandler {

	@Autowired
	@Qualifier("errorMessageSource")
	private MessageSource errormessage;
	
	@Autowired
	@Qualifier("validationMessageSource")
	private MessageSource validationmessage;

	@ExceptionHandler(value = {ApiRequestException.class})
	public ResponseEntity<Object> handleApiRequestException(ApiRequestException exception) {
		return buildResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = {EntityNotFoundException.class})
	public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException exception) {
		String message = errormessage.getMessage("error.notFound", 
				new Object[]{exception.getMessage()}, LocaleContextHolder.getLocale());
		return buildResponseEntity(message, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = {NoSuchElementException.class})
	public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException exception) {
		String message = errormessage.getMessage("error.noSuchElement", 
				new Object[]{exception.getMessage()}, LocaleContextHolder.getLocale());
		return buildResponseEntity(message, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = {EntityExistsException.class})
	public ResponseEntity<Object> handleEntityExistsException(EntityExistsException exception) {
		String message = errormessage.getMessage("error.entityExists", 
				new Object[]{exception.getMessage()}, LocaleContextHolder.getLocale());
		return buildResponseEntity(message, HttpStatus.CONFLICT);
	}
	
	/* TODO Le sysout permet de récupérer le nom du champ en erreur il faut simplement que je créer
	 * ensuite une propriété de message de validation à trou afin de pouvoir la modifier à la volet
	 */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .collect(Collectors.toMap(
                        error -> ((FieldError) error).getField(),
                        error -> verifyPlaceHolder(error.getDefaultMessage(), (FieldError) error),
                        (existing, replacement) -> existing));

        String message = errormessage.getMessage("error.validation", 
                new Object[]{errors.size()}, LocaleContextHolder.getLocale());
        ApiException apiException = new ApiException(message, HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z")));

        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("apiError", apiException);
        responseBody.put("fieldErrors", errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
	
	private ResponseEntity<Object> buildResponseEntity(String message, HttpStatus status) {
		ApiException apiException = new ApiException(message, status, ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(apiException, status);
	}
	
    private String verifyPlaceHolder(String defaultMessage, FieldError error) {
        if (defaultMessage != null && defaultMessage.contains("{0}")) {
            String fieldName = error.getField();
            defaultMessage = defaultMessage.replace("{0}", fieldName);
        }
        return defaultMessage;
    }
}
