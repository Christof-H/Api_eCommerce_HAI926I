package com.android.ecommerce.model.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Category {
    CLOTHING, TOY, FRAGRANCE;

	/*
	 @JsonCreator
	    public static Category fromValue(String value) {
	        for (Category category : Category.values()) {
	            if (category.name().equalsIgnoreCase(value)) {
	                return category;
	            }
	        }
	        throw new IllegalArgumentException("Unknown enum type " + value);
	    }
	    */
}
