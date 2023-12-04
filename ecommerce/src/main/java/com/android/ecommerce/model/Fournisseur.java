package com.android.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="t_fournisseur")
public class Fournisseur {
		//Attributs
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int numfourn;
		private String nom;
		private String prenom;
		private String login;
		private String password;
		private String email;
		private String localite;
		
		//Mapping JPA pour une Enumération :
		@Enumerated(EnumType.STRING)
	    private Categorie categorie;
		
	  //Relation Fournisseur 1 <--> * Produit
	    @OneToMany(targetEntity = Produit.class, mappedBy = "fournisseur")
	    @JsonManagedReference
	    private List<Produit> listProduits= new ArrayList<>();
	    
	  //Relation Fournisseur 1 <--> * Offre
	    @OneToMany(targetEntity = Offre.class, mappedBy = "fournisseur")
	    @JsonManagedReference
	    private List<Offre> listOffres= new ArrayList<>();
	    

	    //Constructeurs
	    public Fournisseur() {}

		public Fournisseur(Integer numfourn, String nom, String prenom, String login, String password, String email, String localite, Categorie categorie, List<Produit> listProduits, List<Offre> listOffres) {
			super();
			this.numfourn = numfourn;
			this.nom = nom;
			this.prenom = prenom;
			this.login = login;
			this.password = password;
			this.email = email;
			this.localite = localite;
			this.categorie = categorie;
			this.listProduits = listProduits;
			this.listOffres = listOffres;
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

		public Integer getNumfourn() {
			return numfourn;
		}

		public void setNumfourn(Integer numfourn) {
			this.numfourn = numfourn;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getLocalite() {
			return localite;
		}

		public void setLocalite(String localite) {
			this.localite = localite;
		}

		public Categorie getCategorie() {
			return categorie;
		}

		public void setCategorie(Categorie categorie) {
			this.categorie = categorie;
		}
		
	}
