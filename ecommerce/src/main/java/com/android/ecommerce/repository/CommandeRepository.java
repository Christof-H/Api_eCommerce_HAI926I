package com.android.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import com.android.ecommerce.model.Commande;


public interface CommandeRepository extends CrudRepository<Commande, Integer>{

}
