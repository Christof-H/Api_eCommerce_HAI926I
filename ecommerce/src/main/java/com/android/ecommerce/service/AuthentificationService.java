package com.android.ecommerce.service;


import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.android.ecommerce.generic.GenericCRUDService;
import com.android.ecommerce.generic.IGenericCRUDRepository;
import com.android.ecommerce.jwt.JwtService;
import com.android.ecommerce.jwt.TokenResponse;
import com.android.ecommerce.model.Client;
import com.android.ecommerce.model.Supplier;
import com.android.ecommerce.model.User;
import com.android.ecommerce.model.enumeration.Role;
import com.android.ecommerce.repository.UserRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;


@Service
public class AuthentificationService extends GenericCRUDService<User>{


	protected AuthentificationService(IGenericCRUDRepository<User> genericRepository) {
		super(genericRepository, User.class);
	}
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private PasswordEncoder passwordEncoder;


	public ResponseEntity<?> inscription(User user) {
		String email = user.getEmail();
		Optional<User> existingUser = userRepository.findByEmail(email);
		if(existingUser.isPresent()) {
			throw new EntityExistsException("L'utilisateur avec le mail : " + existingUser.get().getEmail());
		}else {
			super.create(user);
			String token = jwtService.generateToken(userRepository.findByEmail(email).get());
			TokenResponse tokenResponse =  new TokenResponse(token);
			return ResponseEntity.ok(tokenResponse);
		}
	}	

	public ResponseEntity<?> login(Map<String, String> requestMap) {
			String email = requestMap.get("email");
			String password = requestMap.get("password");
			Optional<User> user = userRepository.findByEmail(email);
			if (user.isPresent() && password.matches(user.get().getPassword())) {
				String token = jwtService.generateToken(user.get());
				TokenResponse tokenResponse = new TokenResponse(token);
				return ResponseEntity.ok(tokenResponse);
			} else {
				throw new EntityNotFoundException(User.class.getSimpleName() + "avec le mail :" + email);
			}
	}

	private User getUserType(User user) {
		if(Role.valueOf(user.getUserType().toString()) == Role.SUPPLIER) {
			return (Supplier) user;  
		}else if (Role.valueOf(user.getUserType().toString()) == Role.CLIENT) {
			return (Client) user;
		}
		return null;
	}

}
