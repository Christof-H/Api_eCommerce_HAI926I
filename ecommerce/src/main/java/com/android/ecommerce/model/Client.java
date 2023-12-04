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
    //@JsonIgnore
    @JsonManagedReference 
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

	public Integer getNumclient() {
		return numclient;
	}

	public void setNumclient(Integer numclient) {
		this.numclient = numclient;
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

	public Categorie getCentre_interet() {
		return centre_interet;
	}

	public void setCentre_interet(Categorie centre_interet) {
		this.centre_interet = centre_interet;
	}

	public List<Commande> getListCommandes() {
		return listCommandes;
	}

	public void setListCommandes(List<Commande> listCommandes) {
		this.listCommandes = listCommandes;
	}
}
