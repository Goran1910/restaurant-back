package com.iis.restaurant.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class PartyMeal {
	@EmbeddedId
	private PartyMealKey partyMealKey;

	@ManyToOne
	@MapsId("partyId")
	@JoinColumn(name = "party_id")
	private Party party;

	@ManyToOne
	@MapsId("mealId")
	@JoinColumn(name = "meal_id")
	private Meal meal;

	private int amount;

	public PartyMeal() {
		super();
	}

	public PartyMealKey getPartyMealKey() {
		return partyMealKey;
	}

	public void setPartyMealKey(PartyMealKey partyMealKey) {
		this.partyMealKey = partyMealKey;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PartyMeal [partyMealKey=" + partyMealKey + ", party=" + party + ", meal=" + meal + ", amount=" + amount
				+ "]";
	}

}
