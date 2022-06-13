package com.iis.restaurant.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PartyMealKey implements Serializable {
	@Column(name = "party_id")
	private Long partyId;

	@Column(name = "meal_id")
	private int mealId;

	public PartyMealKey() {
		super();
	}

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

	public int getMealId() {
		return mealId;
	}

	public void setMealId(int mealId) {
		this.mealId = mealId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(mealId, partyId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PartyMealKey other = (PartyMealKey) obj;
		return Objects.equals(mealId, other.mealId) && Objects.equals(partyId, other.partyId);
	}

	@Override
	public String toString() {
		return "PartyMealKey [partyId=" + partyId + ", mealId=" + mealId + "]";
	}

}
