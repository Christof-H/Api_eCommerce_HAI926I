package com.android.ecommerce.model;

import java.util.ArrayList;

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
import lombok.Data;

@Data
@Entity
@Table(name="t_produit")
public class Produit {
    //Attributs :
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idp;
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
    private Fournisseur fournisseur;
    
    
    //Relation Produit * <--> * Commande
  @ManyToMany
  @JoinTable( name = "prod_in_com",
  joinColumns = @JoinColumn( name = "idp" ),
  inverseJoinColumns = @JoinColumn( name = "idc" ) )
  private ArrayList<Commande> list_commande = new ArrayList<>();
    
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
}
