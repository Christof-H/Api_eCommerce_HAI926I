package com.android.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="t_client")
public class Client {
	//Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numc;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	private String email;
	private String localite;
    //List<Categorie> centreInteret = new ArrayList<>();
    

    //Constructeurs
    public Client() {
    }

	public Client(Integer numc, String nom, String prenom, String login, String password, String email, String localite) {
		super();
		this.numc = numc;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.email = email;
		this.localite = localite;
		//this.centreInteret = centreInteret;
	}
}
