package com.android.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.android.ecommerce.model.Commande;
import com.android.ecommerce.model.Fournisseur;
import com.android.ecommerce.model.Produit;
import com.android.ecommerce.service.FournisseurService;


@RestController
public class FournisseurContoller {
	@Autowired
	FournisseurService fournisseurService;
	
	@GetMapping("/fournisseurs")
	public Iterable<Fournisseur> getClients() {
        return fournisseurService.getFournisseurs();
    }

    @GetMapping("/fournisseur/{numfourn}")
    public Fournisseur getFournisseurById(@PathVariable Integer numfourn) {
        return fournisseurService.getFournisseurById(numfourn);
    }
    
    @PostMapping("/addFournisseur")
	@ResponseStatus(HttpStatus.CREATED)
	public void addFournisseur(@RequestBody Fournisseur fournisseur) {
		fournisseurService.save(fournisseur);
	}
    
    @GetMapping("/fournisseur/{numfourn}/produits")
    public List<Produit> getProduitsByFournisseurId(@PathVariable Integer numfourn) {
        return fournisseurService.getProduitsByFournisseurId(numfourn);
    }
    
    @GetMapping("/fournisseur/{numfourn}/commandes")
    public List<Commande> getCommandeByFournisseurId(@PathVariable Integer numfourn) {
        return fournisseurService.getCommandeByFournisseurId(numfourn);
    }
    
    
}
