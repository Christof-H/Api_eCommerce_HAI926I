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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="t_commande")
public class Commande {
    //Attributs :
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idc;
    private Date date_reglement;
    private Date date_envoi;
    private Float prix_total;
    
	//Mapping JPA pour une Enumération :
	@Enumerated(EnumType.STRING)
    private Statut statut;
    
  //Relation Commande * <--> 1 Client
    @ManyToOne(targetEntity = Client.class)
    @JoinColumn(name="numclient")    
    private Client client;
    
  //Relation Commande * <--> * Produit
    @ManyToMany
    @JoinTable( name = "prod_in_com",
    joinColumns = @JoinColumn( name = "idc" ),
    inverseJoinColumns = @JoinColumn( name = "idp" ) )
    private ArrayList<Produit> list_produit = new ArrayList<>();

    //Constructeurs
    public Commande(){}
    public Commande(Integer id, Date date_reglement, Date date_envoi, Float prix_total, Statut statut, Client client) {
        this.idc = id;
        this.date_reglement = date_reglement;
        this.date_envoi = date_envoi;
        this.prix_total = prix_total;
        this.statut = statut;
        this.client = client;
        //this.list_produit = list_produit;
    }
}
