package com.android.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.android.ecommerce.model.Client;
import com.android.ecommerce.model.Fournisseur;
import com.android.ecommerce.repository.ClientRepository;
import com.android.ecommerce.repository.FournisseurRepository;

@Service
public class FournisseurService {
	@Autowired
	private FournisseurRepository fournisseurRepository;
	
	public Iterable<Fournisseur> getFournisseurs(){
		return fournisseurRepository.findAll();
	}
	
    public Fournisseur getFournisseurById(Integer numf) {
    	Optional<Fournisseur> fournisseur = fournisseurRepository.findById(numf);
    	if (fournisseur != null) {
    		return fournisseur.get();
    	} else {
    	return null;
    	}
    }
    
	public void save (Fournisseur fournisseur) {
		fournisseurRepository.save(fournisseur);
	}
}
