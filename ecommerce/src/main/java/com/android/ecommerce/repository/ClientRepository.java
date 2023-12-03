package com.android.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.android.ecommerce.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer>{

}
