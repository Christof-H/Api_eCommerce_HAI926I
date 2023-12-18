package com.android.ecommerce.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.android.ecommerce.generic.IGenericEntity;
import com.android.ecommerce.model.product.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



@Entity
@Table(name="t_offer")
public class Offer implements IGenericEntity<Offer>, Serializable{

	private static final long serialVersionUID = -6034052110009427998L;
	
	//Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOffer;
	private LocalDate startingDate;
	private LocalDate endingDate;
	private Float discountPercentage;

	//Relation Offre * <--> 1 Fournisseur
	@ManyToOne(targetEntity = Supplier.class)
	@JoinColumn(name="numSupplier") 
	@JsonBackReference
	private Supplier supplier;

	@OneToOne
	@JoinColumn(name = "idProduct")
	private Product product;

	//Constructeurs
	public Offer(){}

	

	@Override
	public Integer getId() {
		return this.idOffer;
	}
	
	public LocalDate getStartingDate() {
		return startingDate;
	}



	public LocalDate getEndingDate() {
		return endingDate;
	}



	public Float getDiscountPercentage() {
		return discountPercentage;
	}


	public Supplier getSupplier() {
		return supplier;
	}



	public Product getProduct() {
		return product;
	}

	public void setIdOffer(int idOffer) {
		this.idOffer = idOffer; 
	}
	
	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}



	public void setEndingDate(LocalDate endingDate) {
		this.endingDate = endingDate;
	}



	public void setDiscountPercentage(Float discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	@Override
	public void update(Offer source) {
		this.idOffer = source.getId();
		this.startingDate = source.getStartingDate();
		this.endingDate = source.getEndingDate();
		this.discountPercentage = source.getDiscountPercentage();
		this.supplier = source.getSupplier();
		this.product = source.getProduct();
	}

	@Override
	public Offer createNewInstance() {
		Offer offer = new Offer();
		offer.update(offer);
		return offer;
	}


}
