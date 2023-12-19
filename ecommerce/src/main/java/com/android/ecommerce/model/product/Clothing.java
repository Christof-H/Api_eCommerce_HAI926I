package com.android.ecommerce.model.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_clothing")
@PrimaryKeyJoinColumn(name = "id_product")
public class Clothing extends Product {
	
	private static final long serialVersionUID = -4320635418373817164L;

	@Column(name = "stock_S")
	private int stockS;
	
	@Column(name = "stock_M")
	private int stockM;
	
	@Column(name = "stock_L")
	private int stockL;
	
	@Column(name = "stock_XL")
	private int stockXL;
	
	public Clothing() {
		super(); 
	}
	
	public int getStockS() {
		return stockS;
	}

	public int getStockM() {
		return stockM;
	}

	public int getStockL() {
		return stockL;
	}

	public int getStockXL() {
		return stockXL;
	}

	public void setStockS(int stockS) {
		this.stockS = stockS;
	}

	public void setStockM(int stockM) {
		this.stockM = stockM;
	}

	public void setStockL(int stockL) {
		this.stockL = stockL;
	}

	public void setStockXL(int stockXL) {
		this.stockXL = stockXL;
	}

	@Override
	public void update(Product source) {
		if (source instanceof Clothing clothingSource) {
			super.update(clothingSource);
			this.stockS = clothingSource.getStockS();
			this.stockM = clothingSource.getStockM();
			this.stockL = clothingSource.getStockL();
			this.stockXL = clothingSource.getStockXL();
		}
	}
	
	@Override
	public Product createNewInstance() {
		Clothing clothing = new Clothing();
		clothing.update(this);
		return clothing;
	}

}
