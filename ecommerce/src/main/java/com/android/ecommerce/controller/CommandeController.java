package com.android.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.android.ecommerce.model.Client;
import com.android.ecommerce.model.Commande;
import com.android.ecommerce.service.CommandeService;

@RestController
public class CommandeController {
	@Autowired
	CommandeService commandeService;
	
	@GetMapping("/commandes")
	public Iterable<Commande> getCommandes() {
        return commandeService.getCommandes();
    }

    @GetMapping("/commande/{idc}")
    public Commande getCommandeById(@PathVariable Integer idc) {
        return commandeService.getCommandeById(idc);
    }
    
    @PostMapping("/addCommande")
	@ResponseStatus(HttpStatus.CREATED)
	public void addCommande(@RequestBody Commande commande) {
		commandeService.save(commande);
	}
}
