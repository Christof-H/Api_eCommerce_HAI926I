package com.android.ecommerce.model.product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.android.ecommerce.generic.IGenericEntity;
import com.android.ecommerce.model.Offer;
import com.android.ecommerce.model.Order;
import com.android.ecommerce.model.Supplier;
import com.android.ecommerce.model.enumeration.Category;
import com.android.ecommerce.validation.DecimalTwoDigits;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;


/**
 * 
 * 
 * Documentation sur la stratégie du mapping d'héritage
 * https://www.axopen.com/blog/2014/03/hibernate-4-heritage-mapping-strategies/
 */

@Entity
@Table(name = "t_product")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "category")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Toy.class, name = "TOY"),
    @JsonSubTypes.Type(value = Clothing.class, name = "CLOTHING"),
    @JsonSubTypes.Type(value = Fragrance.class, name = "FRAGRANCE")
})
public abstract class Product implements IGenericEntity<Product>, Serializable {


	private static final long serialVersionUID = -6031085549196234886L;
	
	// Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_product")
    protected int idProduct;
    
    @NotBlank(message = "{validation.notblank}")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "{validation.only.alphanumeric}")
    protected String reference;
    
    @NotBlank(message = "{validation.notblank}")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]*$", message = "{validation.first.capitalize.alphabetic.space}")
    protected String name;
    
    @NotNull(message = "{validation.notnull}")
    @DecimalTwoDigits
    @Positive
    protected Float price;
    
    @NotBlank(message = "{validation.notblank}")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "{validation.alphabetic.space}")
    protected String description;
    
    @Lob  // Large Object
    @Column(name = "image", columnDefinition="BLOB")
    private byte[] image;

    @Enumerated(EnumType.STRING)
    protected Category category;

    // Relation Product * <--> 1 Supplier
    @ManyToOne(targetEntity = Supplier.class)
    @JoinColumn(name = "idSupplier")
    @JsonBackReference("product-back-reference")
    protected Supplier supplier;

    
    // Relation Product * <--> * Commande
    
    @ManyToMany
    @JoinTable(name = "prod_in_com", joinColumns = @JoinColumn(name = "idProduct"), inverseJoinColumns = @JoinColumn(name = "idOrder"))
    @JsonBackReference
    private List<Order> list_commande;
    
    
    @OneToOne(mappedBy = "product")
    @JsonManagedReference("productOffer-back-reference")
    protected Offer offer;

    // Constructors
    public Product() {}

    // Getters 
    public Integer getId() {
        return idProduct;
    }

	public String getReference() {
		return reference;
	}

	public String getName() {
		return name;
	}

	public Float getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public Category getCategory() {
		return category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	
	public List<Order> getList_commande() {
		return list_commande;
	}
	
	
	public Offer getOffer() {
		return offer;
	}

	public byte[] getImage() {
		return image;
	}

	public void setId(Integer id) {
		this.idProduct = id;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	public void setList_commande(List<Order> list_commande) {
		this.list_commande = list_commande;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	
	
	
	@Override
    public void update(Product source) {
	    this.idProduct = source.getId();
	    this.reference = source.getReference();
	    this.name = source.getName();
	    this.price = source.getPrice();
	    this.description = source.getDescription();
	    this.offer = source.getOffer();
	    this.supplier = source.getSupplier();
	    this.category = source.getCategory();
	    this.image = source.getImage();
    }

	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", reference=" + reference + ", name=" + name + ", price=" + price
				+ ", description=" + description + ", category=" + category + ", supplier=" + supplier + ", offer="
				+ offer + "]";
	}

	

}
