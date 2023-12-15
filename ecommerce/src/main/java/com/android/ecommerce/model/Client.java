package com.android.ecommerce.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.android.ecommerce.model.enumeration.Categorie;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

/**
 *  
 * 
 * En utilisant l'annotation @ElementCollection nous créeons une table 
 * séparé quui contient les listes de catégorie dans lequel l'utilisateur est intéressée
 * ceci permet de ne pas créer une entité en plus. 
 * 
 */
@Entity
@DiscriminatorValue("Client")
public class Client extends User implements Serializable{

	private static final long serialVersionUID = 7464573509860235832L;

	//Mapping JPA pour une Enumération :
	@ElementCollection(targetClass = Categorie.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "client_interests", joinColumns = @JoinColumn(name = "client_id"))
    @Column(name = "interest")
    private Set<Categorie> centre_interet;
	
    //Relation Client 1 <--> * Commande
    @OneToMany(targetEntity = Commande.class, mappedBy = "client")
    @JsonManagedReference
    private List<Commande> listCommandes= new ArrayList<>();
    
    public Client() {
    	super();
    }
    
    //Getter
	public Set<Categorie> getCentre_interet() {
		return centre_interet;
	}

	public List<Commande> getListCommandes() {
		return listCommandes;
	}

	//Setter
	public void setListCommandes(List<Commande> listCommandes) {
		this.listCommandes = listCommandes;
	}
	
	public void setCentre_interet(Set<Categorie> centre_interet) {
		this.centre_interet = centre_interet;
	}

	@Override
	public void update(User source) {
		super.update(source);
		this.centre_interet = getCentre_interet();
	}

	@Override
	public User createNewInstance() {
		Client client = new Client();
		client.update(client);
		return client;
	}
}
