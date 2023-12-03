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
@Table(name="t_client")
public class Client {
	//Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numclient;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	private String email;
	private String localite;
	
	//Mapping JPA pour une Enumération :
	@Enumerated(EnumType.STRING)
    private Categorie centre_interet;
	
    //Relation Client 1 <--> * Commande
    @OneToMany(targetEntity = Commande.class, mappedBy = "client")
    private List<Commande> listCommandes= new ArrayList<>();

    //Constructeurs
    public Client() {}

	public Client(Integer numclient, String nom, String prenom, String login, String password, String email, String localite, Categorie categorie) {
		super();
		this.numclient = numclient;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.email = email;
		this.localite = localite;
		this.centre_interet = categorie;
	}
}
