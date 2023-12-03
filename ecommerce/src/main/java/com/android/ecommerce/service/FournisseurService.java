package com.android.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.android.ecommerce.model.Commande;
import com.android.ecommerce.model.Fournisseur;
import com.android.ecommerce.model.Produit;
import com.android.ecommerce.repository.CommandeRepository;
import com.android.ecommerce.repository.FournisseurRepository;

@Service
public class FournisseurService {
	@Autowired
	private FournisseurRepository fournisseurRepository;
	@Autowired
	private CommandeRepository commandeRepository;
	
	public Iterable<Fournisseur> getFournisseurs(){
		return fournisseurRepository.findAll();
	}
	
    public Fournisseur getFournisseurById(Integer numfourn) {
    	Optional<Fournisseur> fournisseur = fournisseurRepository.findById(numfourn);
    	if (fournisseur != null) {
    		return fournisseur.get();
    	} else {
    	return null;
    	}
    }
    
	public void save (Fournisseur fournisseur) {
		fournisseurRepository.save(fournisseur);
	}
	
	public List<Produit> getProduitsByFournisseurId(Integer numfourn){
		Fournisseur fournisseur = getFournisseurById(numfourn);
		return fournisseur.getListProduits();	
	}
	
	public List<Commande> getCommandeByFournisseurId(Integer numfourn){
		Fournisseur fournisseur = getFournisseurById(numfourn);
		Iterable<Commande> IterableCommande = commandeRepository.findAll();
		List<Commande> listCommandes = new ArrayList<Commande>();
		for (Commande commande : IterableCommande) {
			listCommandes.add(commande);
		}
		
		for (Commande commande : listCommandes) {
			for (Produit produit : commande.getList_produit())
				if (produit.getFournisseur().getNumfourn().equals(numfourn)) {
					if ( !listCommandes.contains(commande)) {
						listCommandes.add(commande);
					}
				}
		}
		return listCommandes;	
	}
	
}
