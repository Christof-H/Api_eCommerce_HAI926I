package com.android.ecommerce.model.enumeration;

import jakarta.persistence.Embeddable;

@Embeddable
public enum Status {
	LIVRÉ,
	EN_ATTENTE_DE_CONFIRMATION,
	SUPPRIMÉE
}
