package com.android.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.android.ecommerce.model.Client;
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
    
	public void saveCommande (Commande commande) {
		commandeRepository.save(commande);
	}
	
	public Commande updateCommande (Integer idc, Commande updatedCommande) {
		Commande commande = commandeRepository.findById(idc).orElse(null);
		if (commande != null) {
			if (updatedCommande.getDate_reglement() != null) {
				commande.setDate_reglement(updatedCommande.getDate_reglement());
			}
			if (updatedCommande.getDate_envoi() != null) {
				commande.setDate_envoi(updatedCommande.getDate_envoi());
			}
			if (updatedCommande.getPrix_total() != null) {
				commande.setPrix_total(updatedCommande.getPrix_total());
			}
			return commandeRepository.save(commande);
		} else {
		return null;
		}
	}
	
}
