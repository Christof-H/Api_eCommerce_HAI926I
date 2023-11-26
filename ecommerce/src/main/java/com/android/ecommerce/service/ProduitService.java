package com.android.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.android.ecommerce.model.Client;
import com.android.ecommerce.model.Produit;
import com.android.ecommerce.repository.ClientRepository;
import com.android.ecommerce.repository.ProduitRepository;

@Service
public class ProduitService {
	@Autowired
	private ProduitRepository produitRepository;
	
	public Iterable<Produit> getProduits(){
		return produitRepository.findAll();
	}
	
    public Produit getProduitById(Integer idp) {
    	Optional<Produit> produit = produitRepository.findById(idp);
    	if (produit != null) {
    		return produit.get();
    	} else {
    	return null;
    	}
    }
    
	public void save (Produit produit) {
		produitRepository.save(produit);
	}
}
