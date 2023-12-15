package com.android.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;


@Entity
@DiscriminatorValue("Supplier")
public class Supplier extends User {

	//Relation Supplier 1 <--> * Produit
	@OneToMany(targetEntity = Produit.class, mappedBy = "fournisseur")
	@JsonManagedReference
	private List<Produit> listProduits= new ArrayList<>();

	//Relation Supplier 1 <--> * Offre
	@OneToMany(targetEntity = Offre.class, mappedBy = "fournisseur")
	@JsonManagedReference
	private List<Offre> listOffres= new ArrayList<>();


	//Constructeurs
	public Supplier() {
		super();
	}

	public void setListProduits (List<Produit> listProduits) {
		this.listProduits = listProduits;
	}
	public List<Produit> getListProduits(){
		return this.listProduits;
	}

	public void setListOffres (List<Offre> listOffres) {
		this.listOffres = listOffres;
	}
	public List<Offre> getListOffres(){
		return this.listOffres ;
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
