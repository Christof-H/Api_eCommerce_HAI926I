package com.android.ecommerce.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="t_produit")
public class Produit {
    //Attributs :
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String reference;
    private String nom;
    private Float prix;
    private String description;
    private String taille;
    private Integer qt_stock;
    private Categorie categorie;

    //Constructeurs:
    public Produit(){}
    public Produit(Integer id, String reference, String nom, Float prix, String description, String taille, Integer qt_stock, Categorie categorie) {
        this.id = id;
        this.reference = reference;
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.taille = taille;
        this.qt_stock = qt_stock;
        this.categorie = categorie;
    }
}
