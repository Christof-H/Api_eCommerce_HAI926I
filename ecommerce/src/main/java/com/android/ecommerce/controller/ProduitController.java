package com.android.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.android.ecommerce.model.Commande;
import com.android.ecommerce.model.Produit;
import com.android.ecommerce.service.ProduitService;

@RestController
public class ProduitController {
	@Autowired
	ProduitService produitService;
	
	@GetMapping("/produits")
	public Iterable<Produit> getProduits() {
        return produitService.getProduits();
    }

    @GetMapping("/produit/{idp}")
    public Produit getProduitById(@PathVariable Integer idp) {
        return produitService.getProduitById(idp);
    }
    
    @PostMapping("/addProduit")
	@ResponseStatus(HttpStatus.CREATED)
	public void addProduit(@RequestBody Produit produit) {
		produitService.save(produit);
	}
}
