package com.android.ecommerce.model.enumeration;

import jakarta.persistence.Embeddable;

@Embeddable
public enum Status {
	LIVRÉE,
	EN_COURS_DE_LIVRAISON,
	EN_ATTENTE_DE_CONFIRMATION,
	SUPPRIMÉE
}
