package com.android.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.android.ecommerce.model.Commande;
import com.android.ecommerce.repository.CommandeRepository;


@Service
public class CommandeService {
	@Autowired
	private CommandeRepository commandeRepository;
	
	public Iterable<Commande> getCommandes(){
		return commandeRepository.findAll();
	}
	
    public Commande getCommandeById(Integer idp) {
    	Optional<Commande> commande = commandeRepository.findById(idp);
    	if (commande != null) {
    		return commande.get();
    	} else {
    	return null;
    	}
    }
    
	public void save (Commande commande) {
		commandeRepository.save(commande);
	}
}
