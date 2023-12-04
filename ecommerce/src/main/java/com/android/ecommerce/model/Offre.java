package com.android.ecommerce.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name="t_offre")
public class Offre {
    //Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ido;
    private Date date_debut;
    private Date date_fin;
    private Float remise;
    
//Mapping JPA pour une Enumération :
	@Enumerated(EnumType.STRING)
    private Categorie categorie;
	
//Relation Offre * <--> 1 Fournisseur
    @ManyToOne(targetEntity = Fournisseur.class)
    @JoinColumn(name="numfourn") 
    @JsonBackReference
    private Fournisseur fournisseur;
	

    //Constructeurs
    public Offre(){}
    
    public Offre(Integer id, Date date_debut, Date date_fin, Float remise, Categorie categorie) {
        this.ido = id;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.remise = remise;
        this.categorie = categorie;
    }

	public Integer getIdo() {
		return ido;
	}

	public void setIdo(Integer ido) {
		this.ido = ido;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public Float getRemise() {
		return remise;
	}

	public void setRemise(Float remise) {
		this.remise = remise;
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
    
}
