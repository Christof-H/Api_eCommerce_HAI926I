package com.android.ecommerce.jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.android.ecommerce.model.Client;
import com.android.ecommerce.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	private static final String SECRET_KEY = "ImBAZ2tF87HyRPlJPNE2CL6y1G9JPYSF+jM7Pi48bjL6Z2pcz7aRjobV+oNFB+EoebY7B85M9/X1y5OsoAlgSs6x4Vqw23ATLVFkJ2nsi6E8HETEicKFAHVFYg6cuhnYEmMrGwgytL0haqsspSjvXGeJluUOz8IksIJrl1fUVEaDrOXsMK88lNpBvKttI55+DqPvc8OW92FJBRu5l1EVYqiA/PI5z+YDsmCjm6QuzkOfLrisgX9oTDFdZ/af4TPkf0xUvrR4mPJ6Mvy72cQ9Dt2mEj2KiHvUHXYnpV+z5XEqTDfzlwvunuwpn/JdpnkgvQDI7OxGZO7s4ycjWnPHk+gE6WACehPHp8X4dtXVFyU=";

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

		public String generateToken(User userDetails) {
		    Map<String, Object> claims = new HashMap<>();

		    // Obtention du rôle à partir de UserDetails
		    String role = userDetails.getAuthorities().stream()
		                             .map(GrantedAuthority::getAuthority)
		                             .findFirst()
		                             .orElse(null);
		    
		    claims.put("role", role);
		    claims.put("lastName", userDetails.getLastName());
		    claims.put("firstName", userDetails.getFirstName());
		    claims.put("email", userDetails.getUsername());
		    claims.put("postcode", userDetails.getPostcode());
		    
		    if(userDetails instanceof Client) {
		    	Client client = (Client) userDetails;
		    	claims.put("interestsCenter", client.getCentre_interet());
		    }

		    return generateToken(claims, userDetails);
			
			/*
			return generateToken(new HashMap<>(), userDetails);*/
		}
	
		public String generateToken(Map<String, Object> extractClaims, UserDetails userDetails) {
			return Jwts.builder()
					.setClaims(extractClaims)
					.setSubject(userDetails.getUsername())
					.setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
					.signWith(getSignInKey(), SignatureAlgorithm.HS256)
					.compact();
		}
	
	public boolean isTokenValid(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	private java.util.Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	private Claims extractAllClaims(String token) {
		return Jwts
				.parserBuilder()
				.setSigningKey(getSignInKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}

	private Key getSignInKey() {
		byte[] keyBites = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBites);
	}

}
