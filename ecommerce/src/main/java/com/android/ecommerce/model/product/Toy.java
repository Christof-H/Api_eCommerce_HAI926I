package com.android.ecommerce.model.product;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "t_toy")
@PrimaryKeyJoinColumn(name = "id_product")
public class Toy extends Product{

	private static final long serialVersionUID = -8563119925040352781L;
	
	@Min(value = 0)
	@Max(value = 99)
	private int recommendedAge;

	
	public int getRecommendedAge() {
		return recommendedAge;
	}



	public void setRecommendedAge(int recommendedAge) {
		this.recommendedAge = recommendedAge;
	}

	
    /**
     * Met à jour cette instance de Toy avec les attributs d'une autre instance de Toy.
     * @param source L'instance de Toy source dont les attributs seront utilisés pour la mise à jour.
     * @return L'instance de Toy mise à jour.
     */
    @Override
    public void update(Product source) {
        if (source instanceof Toy toySource) {
            System.out.println(source.toString());
            super.update(toySource);
            this.recommendedAge = toySource.getRecommendedAge();
        }
    }

	@Override
	public Product createNewInstance() {
		Toy toy = new Toy();
		toy.update(this);
		return toy;
	}



	@Override
	public String toString() {
		return "Toy [recommendedAge=" + recommendedAge + "]" + super.toString();
	}
	
	

}
