package com.android.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.android.ecommerce.generic.GenericCRUDController;
import com.android.ecommerce.generic.IGenericCRUDRepository;
import com.android.ecommerce.model.Offer;



@RestController
@RequestMapping("/offer")
//@Api(value = "Offer Controller", description = "Controller for managing offers")
public class OfferController extends GenericCRUDController<Offer> {


    protected OfferController(IGenericCRUDRepository<Offer> genericRepository) {
        super(genericRepository, Offer.class);
    }

	/*
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
    */
}
