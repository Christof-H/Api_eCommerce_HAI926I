package com.android.ecommerce.service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.android.ecommerce.generic.GenericCRUDService;
import com.android.ecommerce.generic.IGenericCRUDRepository;
import com.android.ecommerce.model.Supplier;
import com.android.ecommerce.model.product.Product;
import com.android.ecommerce.repository.ProductRepository;

@Service
public class ProductService extends GenericCRUDService<Product> {


	@Autowired
	private ProductRepository productRepository;

	@Autowired
	protected ProductService(IGenericCRUDRepository<Product> genericRepository) {
	    super(genericRepository, Product.class);
	}


	public Product saveImageOfProduct(Product product, MultipartFile imageFile) {
		try {
	        byte[] imageBytes = imageFile.getBytes();
	        //product.setImage(imageBytes);
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
		return product;
	}
    
	public ResponseEntity<List<Product>> getProductBySupplier(Integer supplierId) {
	    List<Product> products = super.findAll().stream()
	            .filter(product -> product.getSupplier() != null && product.getSupplier().getId().equals(supplierId))
	            .collect(Collectors.toList());

	    return ResponseEntity.ok(products);
	}
	
	public ResponseEntity<List<Product>> getProductLikeName(String name) {
		List<Product> products = super.findAll().stream()
		            .filter(product -> product.getName().startsWith(name))
		            .collect(Collectors.toList());
	    if(products.isEmpty()) {
	    	throw new NoSuchElementException("no element start with " + name);
	    }else {
	    	return ResponseEntity.ok(products);
	    }
	}
}
