package com.android.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="t_fournisseur")
public class Fournisseur {
		//Attributs
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer numf;
		private String nom;
		private String prenom;
		private String login;
		private String password;
		private String email;
		private String localite;
	    //List<Categorie> centreInteret = new ArrayList<>();
	    

	    //Constructeurs
	    public Fournisseur() {
	    }

		public Fournisseur(Integer numf, String nom, String prenom, String login, String password, String email, String localite) {
			super();
			this.numf = numf;
			this.nom = nom;
			this.prenom = prenom;
			this.login = login;
			this.password = password;
			this.email = email;
			this.localite = localite;
			//this.centreInteret = centreInteret;
		}
	}
