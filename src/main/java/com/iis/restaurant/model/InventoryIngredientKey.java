package com.iis.restaurant.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InventoryIngredientKey implements Serializable {
	@Column(name = "ing_id")
	private String ingId;

	@Column(name = "inv_id")
	private String invId;

	public InventoryIngredientKey() {
		super();
	}

	public String getIngId() {
		return ingId;
	}

	public void setIngId(String ingId) {
		this.ingId = ingId;
	}

	public String getInvId() {
		return invId;
	}

	public void setInvId(String invId) {
		this.invId = invId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ingId, invId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InventoryIngredientKey other = (InventoryIngredientKey) obj;
		return Objects.equals(ingId, other.ingId) && Objects.equals(invId, other.invId);
	}

	@Override
	public String toString() {
		return "InventoryIngredientKey [ingId=" + ingId + ", invId=" + invId + "]";
	}

}
