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
		Iterable<Client> listClient = clientRepository.findAll();
		for (Client client : listClient) {
			System.out.println(client.getNom());
		}
		return listClient;
		//return clientRepository.findAll();
	}
	
    public Client getClientById(Integer numclient) {
    	Optional<Client> client = clientRepository.findById(numclient);
    	if (client != null) {
    		return client.get();
    	} else {
    	return null;
    	}
    }
    
	public Client saveClient (Client client) {
		Client savedClient = clientRepository.save(client);
		return savedClient;
	}
	
	public Client updateClient(Integer numclient, Client updatedClient) {
		Client client = clientRepository.findById(numclient).orElse(null);
		if (client != null) {
			if (updatedClient.getNom() != null) {
				client.setNom(updatedClient.getNom());
			}
			if (updatedClient.getPrenom() != null) {
				client.setPrenom(updatedClient.getPrenom());
			}
			if (updatedClient.getLogin() != null) {
				client.setLogin(updatedClient.getLogin());
			}
			if (updatedClient.getPassword() != null) {
				client.setPassword(updatedClient.getPassword());
			}
			if (updatedClient.getEmail() != null) {
				client.setEmail(updatedClient.getEmail());
			}
			if (updatedClient.getLocalite() != null) {
				client.setLocalite(updatedClient.getLocalite());
			}
			if (updatedClient.getCentre_interet() != null) {
				client.setCentre_interet(updatedClient.getCentre_interet());
			}
			return clientRepository.save(client);
		} else {
			return null;
		}
	}
	
	public void deleteClientById(Integer numclient) {
		clientRepository.deleteById(numclient);
	}
}
