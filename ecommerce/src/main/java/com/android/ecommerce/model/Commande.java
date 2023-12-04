package com.android.ecommerce.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name="t_commande")
/*@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "idc")*/
public class Commande {
    //Attributs :
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idc;
    private Date date_reglement;
    private Date date_envoi;
    private Float prix_total;
    
	//Mapping JPA pour une Enumération :
	@Enumerated(EnumType.STRING)
    private Statut statut;
    
  //Relation Commande * <--> 1 Client
    @ManyToOne(targetEntity = Client.class)
    @JoinColumn(name="numclient") 
    @JsonBackReference
    private Client client;
    
  //Relation Commande * <--> * Produit
    @ManyToMany
    @JoinTable( name = "prod_in_com",
    joinColumns = @JoinColumn( name = "idc" ),
    inverseJoinColumns = @JoinColumn( name = "idp" ))
    @JsonManagedReference
    private List<Produit> list_produit = new ArrayList<>();

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
	public Integer getIdc() {
		return idc;
	}
	public void setIdc(Integer idc) {
		this.idc = idc;
	}
	public Date getDate_reglement() {
		return date_reglement;
	}
	public void setDate_reglement(Date date_reglement) {
		this.date_reglement = date_reglement;
	}
	public Date getDate_envoi() {
		return date_envoi;
	}
	public void setDate_envoi(Date date_envoi) {
		this.date_envoi = date_envoi;
	}
	public Float getPrix_total() {
		return prix_total;
	}
	public void setPrix_total(Float prix_total) {
		this.prix_total = prix_total;
	}
	public Statut getStatut() {
		return statut;
	}
	public void setStatut(Statut statut) {
		this.statut = statut;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
	public List<Produit> getList_produit() {
		return list_produit;
	}
	public void setList_produit(ArrayList<Produit> list_produit) {
		this.list_produit = list_produit;
	}
    
    
}
