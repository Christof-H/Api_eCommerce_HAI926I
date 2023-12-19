package com.android.ecommerce.controller;

import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {
	/*
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
		commandeService.saveCommande(commande);
	}
    @PatchMapping("/commande/{idc}")
	@ResponseStatus(HttpStatus.OK)
	public Commande updateCommande(@PathVariable Integer idc, @RequestBody Commande updatedCommande) {
		return commandeService.updateCommande(idc, updatedCommande);
	}
	*/
}
