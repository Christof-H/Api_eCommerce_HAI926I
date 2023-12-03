package com.android.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="t_fournisseur")
public class Fournisseur {
		//Attributs
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer numfourn;
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
	    private List<Produit> listProduits= new ArrayList<>();
	    
	  //Relation Fournisseur 1 <--> * Offre
	    @OneToMany(targetEntity = Offre.class, mappedBy = "fournisseur")
	    private List<Offre> listOffres= new ArrayList<>();
	    

	    //Constructeurs
	    public Fournisseur() {}

		public Fournisseur(Integer numfourn, String nom, String prenom, String login, String password, String email, String localite, Categorie categorie) {
			super();
			this.numfourn = numfourn;
			this.nom = nom;
			this.prenom = prenom;
			this.login = login;
			this.password = password;
			this.email = email;
			this.localite = localite;
			this.categorie = categorie;
		}
	}
