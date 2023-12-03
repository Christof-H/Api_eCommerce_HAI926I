package com.android.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.android.ecommerce.model.Offre;

@Repository
public interface OffreRepository extends CrudRepository<Offre, Integer>{

}
