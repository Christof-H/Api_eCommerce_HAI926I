package com.android.ecommerce.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

/**
 * ApiException est utilisée en tant que payload pour représenter les détails d'une erreur survenue dans l'API.
 * Cette classe encapsule les informations sur l'erreur, y compris un message d'erreur,
 * le statut HTTP associé et le timestamp de l'erreur.
 */
public class ApiException {

	private final String message;
	private final HttpStatus httpStatus;
	private final ZonedDateTime timestamp;

	/**
	 * Constructeur pour créer une instance d'ApiException.
	 *
	 * @param message Le message d'erreur détaillé.
	 * @param httpStatus Le statut HTTP associé à l'erreur.
	 * @param timestamp Le moment où l'erreur s'est produite.
	 */
	public ApiException(String message, HttpStatus httpStatus, ZonedDateTime timestamp) {
		this.message = message;
		this.httpStatus = httpStatus;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

}
