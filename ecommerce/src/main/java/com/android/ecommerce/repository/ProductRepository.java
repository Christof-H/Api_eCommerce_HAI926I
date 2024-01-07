package com.android.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.android.ecommerce.generic.IGenericCRUDRepository;
import com.android.ecommerce.model.product.Product;

public interface ProductRepository<T> extends IGenericCRUDRepository<Product>{

	@Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT(:name, '%')")
	List<Product> findProductsStartingWithName(@Param("name") String name);

}
