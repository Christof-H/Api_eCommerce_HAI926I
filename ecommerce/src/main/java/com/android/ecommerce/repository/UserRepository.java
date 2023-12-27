package com.android.ecommerce.repository;

import java.util.Optional;

import com.android.ecommerce.generic.IGenericCRUDRepository;
import com.android.ecommerce.model.User;

public interface UserRepository extends IGenericCRUDRepository<User>{
	
	Optional<User> findByEmail(String email);

}
