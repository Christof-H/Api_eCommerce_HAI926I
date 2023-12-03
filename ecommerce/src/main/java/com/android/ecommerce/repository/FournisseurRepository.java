package com.android.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.android.ecommerce.model.Fournisseur;

@Repository
public interface FournisseurRepository extends CrudRepository<Fournisseur, Integer>{

}