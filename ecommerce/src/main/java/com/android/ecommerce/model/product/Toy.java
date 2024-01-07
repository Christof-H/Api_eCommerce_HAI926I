package com.android.ecommerce.model.product;

import java.io.Serializable;

import com.android.ecommerce.model.enumeration.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "t_toy")
@PrimaryKeyJoinColumn(name = "id_product")
public class Toy extends Product implements Serializable{
	
	@Column(name = "stock")
	@PositiveOrZero
	private int stock = 0;
	
    public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
     * Met à jour cette instance de Toy avec les attributs d'une autre instance de Toy.
     * @param source L'instance de Toy source dont les attributs seront utilisés pour la mise à jour.
     * @return L'instance de Toy mise à jour.
     */
    @Override
    public void update(Product source) {
        if (source instanceof Toy toySource) {
            super.update(toySource);
            this.stock = toySource.getStock();
        }
    }

	@Override
	public Product createNewInstance() {
		Toy toy = new Toy();
		toy.update(this);
    	toy.setCategory(Category.TOY);
		return toy;
	}



	@Override
	public String toString() {
		return super.toString();
	}
	
	

}
