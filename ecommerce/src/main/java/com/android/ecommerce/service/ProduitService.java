package com.android.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.android.ecommerce.model.Categorie;
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
    
	public void saveProduct (Produit produit) {
		produitRepository.save(produit);
	}
	
	public Produit getProductByName(String productName) {
		Iterable<Produit> listPoduits = produitRepository.findAll();
		for (Produit produit : listPoduits) {
			if (produit.getNom().equals(productName)) {
				return produit;
			}
		}
		return null;
	}
	
	public List<Produit> getProductByCat(Categorie cat){
		Iterable<Produit> listPoduits = produitRepository.findAll();
		List<Produit> listProdByCat = new ArrayList<Produit>();
		for (Produit produit : listPoduits) {
			if (produit.getCategorie().equals(cat)) {
				listProdByCat.add(produit);
			}
		}
		return listProdByCat;
	}
	
	public Produit updateProduit(Integer idp, Produit updatedProduit) {
		Produit produit = produitRepository.findById(idp).orElse(null);
		if (produit != null) {
			if (updatedProduit.getReference() != null) {
				produit.setReference(updatedProduit.getReference());
			}
			if (updatedProduit.getNom() != null) {
				produit.setNom(updatedProduit.getNom());
			}
			if (updatedProduit.getPrix() != null) {
				produit.setPrix(updatedProduit.getPrix());
			}
			if (updatedProduit.getDescription() != null) {
				produit.setDescription(updatedProduit.getDescription());
			}
			if (updatedProduit.getTaille() != null) {
				produit.setTaille(updatedProduit.getTaille());
			}
			if (updatedProduit.getQt_stock() != null) {
				produit.setQt_stock(updatedProduit.getQt_stock());
			}
			return produitRepository.save(produit);
		} else {
			return null;
		}
	}
	
}
