package com.android.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import com.android.ecommerce.model.Produit;


public interface ProduitRepository extends CrudRepository<Produit, Integer>{

}
