package com.android.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.android.ecommerce.model.Client;
import com.android.ecommerce.repository.ClientRepository;


@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	
	public Iterable<Client> getClients(){
		return clientRepository.findAll();
	}
	
    public Client getClientById(Integer numc) {
    	Optional<Client> client = clientRepository.findById(numc);
    	if (client != null) {
    		return client.get();
    	} else {
    	return null;
    	}
    }
    
	public void save (Client client) {
		clientRepository.save(client);
	}
}
