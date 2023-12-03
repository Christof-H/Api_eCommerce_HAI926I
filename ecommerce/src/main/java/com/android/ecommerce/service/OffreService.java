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
    
	public void saveOffre (Offre offre) {
		offreRepository.save(offre);
	}
	
	public Offre updateOffre (Integer ido, Offre updatedOffre) {
		Offre offre = offreRepository.findById(ido).orElse(null);;
		if (offre!=null) {
			if (updatedOffre.getDate_debut() != null) {
				offre.setDate_debut(updatedOffre.getDate_debut());
			}
			if (updatedOffre.getDate_fin() != null) {
				offre.setDate_fin(updatedOffre.getDate_fin());
			}
			if (updatedOffre.getRemise() != null) {
				offre.setRemise(updatedOffre.getRemise());
			}
			if (updatedOffre.getCategorie() != null) {
				offre.setCategorie(updatedOffre.getCategorie());
			}
			if (updatedOffre.getFournisseur() != null) {
				offre.setFournisseur(updatedOffre.getFournisseur());
			}
			return offreRepository.save(offre);
		} else {
			return null;
		}
	}
}

