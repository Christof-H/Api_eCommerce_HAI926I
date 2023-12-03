package com.android.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.android.ecommerce.model.Commande;

@Repository
public interface CommandeRepository extends CrudRepository<Commande, Integer>{

}
