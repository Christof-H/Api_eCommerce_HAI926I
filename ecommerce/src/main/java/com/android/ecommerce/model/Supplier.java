package com.android.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import com.android.ecommerce.model.product.Product;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;


@Entity
@DiscriminatorValue("Supplier")
public class Supplier extends User {

	//Relation Supplier 1 <--> * Produit
	@OneToMany(targetEntity = Product.class, mappedBy = "supplier")
	@JsonManagedReference
	private List<Product> listProducts= new ArrayList<>();

	//Relation Supplier 1 <--> * Offre
	@OneToMany(targetEntity = Offer.class, mappedBy = "supplier")
	@JsonManagedReference
	private List<Offer> listOffer= new ArrayList<>();
	
	/*
	@OneToMany(targetEntity = Order.class)
	private List<Order> listOrder = new ArrayList<>();
	*/
	
	//Constructeurs
	public Supplier() {
		super();
	}

	public void setListProduits (List<Product> listProducts) {
		this.listProducts = listProducts;
	}
	public List<Product> getListProduits(){
		return this.listProducts;
	}

	public void setListOffres (List<Offer> listOffres) {
		this.listOffer = listOffres;
	}
	public List<Offer> getListOffres(){
		return this.listOffer ;
	}

	@Override
	public void update(User source) {
		super.update(source);
	}

	@Override
	public User createNewInstance() {
		Supplier supplier = new Supplier();
		supplier.update(supplier);
		return supplier;
	}

}
