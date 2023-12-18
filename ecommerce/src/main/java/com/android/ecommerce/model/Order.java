package com.android.ecommerce.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.android.ecommerce.generic.IGenericEntity;
import com.android.ecommerce.model.enumeration.Status;
import com.android.ecommerce.model.product.Product;
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
@Table(name="t_order")
public class Order implements IGenericEntity<Order>, Serializable {
	
	private static final long serialVersionUID = 1605507221790702249L;
	
	//Attributs :
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrder;
    private LocalDate payementDate;
    private LocalDate deliveryDate;
    private Float price;
    
	//Mapping JPA pour une Enumération :
	@Enumerated(EnumType.STRING)
    private Status status;
    
  //Relation Commande * <--> 1 Client
    @ManyToOne(targetEntity = Client.class)
    @JoinColumn(name="numClient") 
    @JsonBackReference
    private Client client;
    
  //Relation Commande * <--> * Produit
    @ManyToMany
    @JoinTable( name = "prod_in_com",
    joinColumns = @JoinColumn( name = "idOrder" ),
    inverseJoinColumns = @JoinColumn( name = "idProduct" ))
    @JsonManagedReference
    private List<Product> orderedProducts = new ArrayList<>();

    //Constructeurs
    public Order(){}

    
    @Override
	public Integer getId() {
		return this.idOrder;
	}
    
    
	public LocalDate getPayementDate() {
		return payementDate;
	}


	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}


	public Float getPrice() {
		return price;
	}


	public Status getStatus() {
		return status;
	}


	public Client getClient() {
		return client;
	}


	public List<Product> getOrderedProducts() {
		return orderedProducts;
	}


	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	
	public void setPayementDate(LocalDate payementDate) {
		this.payementDate = payementDate;
	}


	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	public void setPrice(Float price) {
		this.price = price;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public void setOrderedProducts(List<Product> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}


	@Override
	public void update(Order source) {
		this.idOrder = source.getId();
		this.deliveryDate = source.getDeliveryDate();
		this.payementDate = source.getPayementDate();
		this.price = source.getPrice();
		this.status = source.getStatus();
		this.client = source.getClient();
		this.orderedProducts = source.getOrderedProducts();
	}

	@Override
	public Order createNewInstance() {
		Order order = new Order();
		order.update(order);
		return order;
	}


    
}
