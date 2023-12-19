package com.android.ecommerce.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;
@ControllerAdvice
public class ApiExceptionHandler {

    @Autowired
    @Qualifier("errorMessageSource")
    private MessageSource errormessage;

    private ResponseEntity<Object> buildResponseEntity(String message, HttpStatus status) {
        ApiException apiException = new ApiException(message, status, ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiException, status);
    }

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
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                                .getAllErrors()
                                .stream()
                                .map(ObjectError::getDefaultMessage)
                                .collect(Collectors.toList());
        return buildResponseEntity(errors.toString(), HttpStatus.BAD_REQUEST);
    }
}
