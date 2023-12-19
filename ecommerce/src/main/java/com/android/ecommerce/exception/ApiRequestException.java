package com.android.ecommerce.exception;

/**
 * ApiRequestException est une exception personnalisée qui étend RuntimeException.
 * Elle est utilisée pour représenter des erreurs spécifiques qui peuvent survenir lors des requêtes API.
 * Cette exception peut être utilisée pour indiquer des problèmes tels que des entrées invalides ou des situations
 * où les attentes de l'API ne sont pas remplies.
 */
public class ApiRequestException extends RuntimeException {

	private static final long serialVersionUID = -7321696099849578427L;
	
	public ApiRequestException(String message) {
		super(message);
	}
	
	public ApiRequestException(String message, Throwable cause) {
		super(message, cause);
	}
}
