package com.android.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.android.ecommerce.model.Offre;
import com.android.ecommerce.repository.OffreRepository;

@Service
public class OffreService {
	@Autowired
	private OffreRepository offreRepository;
	
	public Iterable<Offre> getOffres(){
		return offreRepository.findAll();
	}
	
    public Offre getOffreById(Integer ido) {
    	Optional<Offre> offre = offreRepository.findById(ido);
    	if (offre != null) {
    		return offre.get();
    	} else {
    	return null;
    	}
    }
    
	public void save (Offre offre) {
		offreRepository.save(offre);
	}
}

