package com.android.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="t_produit")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property = "idp")
public class Produit {
    //Attributs :
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idp;
    private String reference;
    private String nom;
    private Float prix;
    private String description;
    private String taille;
    private Integer qt_stock;
    
	//Mapping JPA pour une Enumération :
	@Enumerated(EnumType.STRING)
    private Categorie categorie;
	
	//Relation Produit * <--> 1 Fournisseur
    @ManyToOne(targetEntity = Fournisseur.class)
    @JoinColumn(name="numfourn")
    @JsonBackReference
    private Fournisseur fournisseur;
    
    
    //Relation Produit * <--> * Commande
  @ManyToMany
  @JoinTable( name = "prod_in_com",
  joinColumns = @JoinColumn( name = "idp" ),
  inverseJoinColumns = @JoinColumn( name = "idc" ) )
  @JsonBackReference
  private List<Commande> list_commande = new ArrayList<>();
    
    //Constructeurs:
    public Produit(){}
    
    public Produit(Integer id, String reference, String nom, Float prix, String description, String taille, Integer qt_stock, Categorie categorie) {
        this.idp = id;
        this.reference = reference;
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.taille = taille;
        this.qt_stock = qt_stock;
        this.categorie = categorie;
    }

	public Integer getIdp() {
		return idp;
	}

	public void setIdp(Integer idp) {
		this.idp = idp;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}

	public Integer getQt_stock() {
		return qt_stock;
	}

	public void setQt_stock(Integer qt_stock) {
		this.qt_stock = qt_stock;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public List<Commande> getList_commande() {
		return list_commande;
	}

	public void setList_commande(ArrayList<Commande> list_commande) {
		this.list_commande = list_commande;
	}
	
}
