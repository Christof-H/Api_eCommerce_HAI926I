package com.android.ecommerce.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="t_offre")
public class Offre {
    //Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ido;
    private Date date_debut;
    private Date date_fin;
    private Float remise;
    
//Mapping JPA pour une Enumération :
	@Enumerated(EnumType.STRING)
    private Categorie categorie;
	
//Relation Offre * <--> 1 Fournisseur
    @ManyToOne(targetEntity = Fournisseur.class)
    @JoinColumn(name="numfourn")    
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
}
