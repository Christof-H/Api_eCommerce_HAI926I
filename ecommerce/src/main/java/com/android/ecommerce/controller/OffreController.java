package com.android.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.android.ecommerce.model.Offre;
import com.android.ecommerce.service.OffreService;

@RestController
public class OffreController {
	@Autowired
	OffreService offreService;
	
	@GetMapping("/offres")
	public Iterable<Offre> getOffres() {
        return offreService.getOffres();
    }

    @GetMapping("/offre/{ido}")
    public Offre getOffreById(@PathVariable Integer ido) {
        return offreService.getOffreById(ido);
    }
    
    @PostMapping("/addOffre")
	@ResponseStatus(HttpStatus.CREATED)
	public void addOffre(@RequestBody Offre offre) {
		offreService.saveOffre(offre);
	}
    
    @PatchMapping("/promotion/{ido}")
    public Offre updateOffre (@PathVariable Integer ido, @RequestBody Offre updatedOffre) {
    	return offreService.updateOffre(ido, updatedOffre);
    }
}
