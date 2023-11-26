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
@Table(name="t_commande")
public class Commande {
    //Attributs :
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date_reglement;
    private Date date_envoi;
    private Float prix_total;
    private Statut statut;
    private Integer id_client;
    //private ArrayList<Produit> list_produit = new ArrayList<>();

    //Constructeurs
    public Commande(){}
    public Commande(Integer id, Date date_reglement, Date date_envoi, Float prix_total, Statut statut, Integer id_client) {
        this.id = id;
        this.date_reglement = date_reglement;
        this.date_envoi = date_envoi;
        this.prix_total = prix_total;
        this.statut = statut;
        this.id_client = id_client;
        //this.list_produit = list_produit;
    }
}
