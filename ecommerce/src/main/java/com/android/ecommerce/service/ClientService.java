package com.android.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.android.ecommerce.model.Client;
import com.android.ecommerce.repository.ClientRepository;
import com.android.ecommerce.repository.UserRepository;

@Service
public class ClientService {

	
	@Autowired
	private ClientRepository clientRepository;
	
	  public ResponseEntity<Client> getClientById(Integer clientId) {
	        // Use the clientRepository to fetch the client by ID
	        Client client = clientRepository.findById(clientId)
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));

	        return ResponseEntity.ok(client);
	    }
	
}
