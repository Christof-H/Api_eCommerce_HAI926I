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
@Table(name="t_offre")
public class Offre {
    //Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date_debut;
    private Date date_fin;
    private Float remise;
    private Categorie categorie;

    //Constructeurs
    public Offre(){}
    public Offre(Integer id, Date date_debut, Date date_fin, Float remise, Categorie categorie) {
        this.id = id;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.remise = remise;
        this.categorie = categorie;
    }
}
