package com.android.ecommerce.model.product;

import java.io.Serializable;

import com.android.ecommerce.model.enumeration.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "t_clothing")
@PrimaryKeyJoinColumn(name = "id_product")
public class Clothing extends Product implements Serializable {

	@Column(name = "stock_S")
	@PositiveOrZero
	private int stockS = 0;
	
	@Column(name = "stock_M")
	@PositiveOrZero
	private int stockM = 0;
	
	@Column(name = "stock_L")
	@PositiveOrZero
	private int stockL = 0 ;
	
	@Column(name = "stock_XL")
	@PositiveOrZero
	private int stockXL = 0;
	
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
		clothing.setCategory(Category.CLOTHING);
		return clothing;
	}

}
