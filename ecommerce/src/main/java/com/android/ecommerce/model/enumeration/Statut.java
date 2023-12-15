package com.android.ecommerce.model.enumeration;

import jakarta.persistence.Embeddable;

@Embeddable
public enum Statut {
	DELIVERED,
	PENDING_CONFIRMATION,
	CANCEL
}
