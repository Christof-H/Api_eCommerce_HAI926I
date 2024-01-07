package com.android.ecommerce.model;

import java.io.Serializable;
import java.time.LocalDate;

import org.checkerframework.checker.optional.qual.Present;

import com.android.ecommerce.generic.IGenericEntity;
import com.android.ecommerce.model.product.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;



@Entity
@Table(name="t_offer")
public class Offer implements IGenericEntity<Offer>, Serializable{

	private static final long serialVersionUID = -6034052110009427998L;
	
	//Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOffer;
	
	
	@NotNull(message = "{validation.notnull}")
	@DecimalMin(value = "0.00")
	@DecimalMax(value = "0.99")
	private Float discountPercentage;

	//Relation Offre * <--> 1 Fournisseur
	@ManyToOne(targetEntity = Supplier.class)
	@JoinColumn(name="numSupplier") 
	@JsonBackReference("supplier-back-reference")
	private Supplier supplier;

	@OneToOne
    @JoinColumn(name = "idProduct")
	@JsonBackReference("productOffer-back-reference")
	private Product product;

	//Constructeurs
	public Offer(){}

	

	@Override
	public Integer getId() {
		return this.idOffer;
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
		this.discountPercentage = source.getDiscountPercentage();
		this.supplier = source.getSupplier();
		this.product = source.getProduct();
	}

	@Override
	public Offer createNewInstance() {
		Offer offer = new Offer();
		offer.update(this);
		return offer;
	}


}
