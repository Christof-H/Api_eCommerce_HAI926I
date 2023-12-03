package com.android.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.android.ecommerce.model.Produit;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Integer>{

}
