package com.android.ecommerce.jwt;


public class TokenResponse {
	 private String token;

	    public TokenResponse(String token) {
	        this.token = token;
	    }

	    // Getter and Setter
	    public String getToken() {
	        return token;
	    }

	    public void setToken(String token) {
	        this.token = token;
	    }

}
