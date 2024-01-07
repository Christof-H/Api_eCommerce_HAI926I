package com.android.ecommerce.repository;

import com.android.ecommerce.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {
    // You can add custom query methods here if needed
}
