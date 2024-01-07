package com.android.ecommerce.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.android.ecommerce.model.enumeration.Role;
import com.android.ecommerce.model.product.Product;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;


@Entity
@DiscriminatorValue("user_supplier")
public class Supplier extends User {

	//Relation Supplier 1 <--> * Produit
	@OneToMany(targetEntity = Product.class, mappedBy = "supplier")
	@JsonManagedReference("product-back-reference")
	private List<Product> listProducts= new ArrayList<>();

	//Relation Supplier 1 <--> * Offre
	@OneToMany(targetEntity = Offer.class, mappedBy = "supplier")
	@JsonManagedReference("supplier-back-reference")
	private List<Offer> listOffer= new ArrayList<>();
	
	
	@OneToMany(targetEntity = Order.class, mappedBy = "supplier")
	@JsonManagedReference("order-back-reference")
	private List<Order> listOrder= new ArrayList<>();
	
	//Constructeurs
	public Supplier() {
		super();
	}


	public List<Product> getListProducts() {
		return listProducts;
	}




	public List<Offer> getListOffer() {
		return listOffer;
	}




	public List<Order> getListOrder() {
		return listOrder;
	}




	public void setListProducts(List<Product> listProducts) {
		this.listProducts = listProducts;
	}




	public void setListOffer(List<Offer> listOffer) {
		this.listOffer = listOffer;
	}




	public void setListOrder(List<Order> listOrder) {
		this.listOrder = listOrder;
	}




	@Override
	public void update(User source) {
		super.update(source);
	}

	@Override
	public User createNewInstance() {
		Supplier supplier = new Supplier();
		supplier.update(this);
		supplier.setUserType(Role.SUPPLIER);
		return supplier;
	}


}
