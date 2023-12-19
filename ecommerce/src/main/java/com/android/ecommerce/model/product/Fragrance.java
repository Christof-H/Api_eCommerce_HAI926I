package com.android.ecommerce.model.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_fragrance")
@PrimaryKeyJoinColumn(name = "id_product")
public class Fragrance extends Product {

	private static final long serialVersionUID = 920626609743459997L;

	@Column(name = "stock_30_ml")
	private int stock30Ml;

	@Column(name = "stock_50_ml")
	private int stock50Ml;

	@Column(name = "stock_100_ml")
	private int stock100Ml;

	public Fragrance() {
		super(); 
	}

	public int getStock30Ml() {
		return stock30Ml;
	}

	public int getStock50Ml() {
		return stock50Ml;
	}

	public int getStock100Ml() {
		return stock100Ml;
	}

	public void setStock30Ml(int stock30Ml) {
		this.stock30Ml = stock30Ml;
	}

	public void setStock50Ml(int stock50Ml) {
		this.stock50Ml = stock50Ml;
	}

	public void setStock100Ml(int stock100Ml) {
		this.stock100Ml = stock100Ml;
	}

	/**
	 * Met à jour cette instance de Fragrance avec les attributs d'une autre instance de Fragrance.
	 * @param source L'instance de Fragrance source dont les attributs seront utilisés pour la mise à jour.
	 * @return L'instance de Fragrance mise à jour.
	 */
	@Override
	public void update(Product source) {
		if (source instanceof Fragrance fragranceSource) {
			super.update(fragranceSource);
			this.stock30Ml = fragranceSource.getStock30Ml();
			this.stock50Ml = fragranceSource.getStock50Ml();
			this.stock100Ml = fragranceSource.getStock100Ml();
					
		}
	}


	@Override
	public Product createNewInstance() {
		Fragrance fragrance = new Fragrance();
		fragrance.update(this);
		return fragrance;
	}

}
