package com.iis.restaurant.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class InventoryIngredient {

	@EmbeddedId
	private InventoryIngredientKey invIngKey;

	@ManyToOne
	@MapsId("ingId")
	@JoinColumn(name = "ing_id")
	private Ingredient ingredient;

	@ManyToOne
	@MapsId("invId")
	@JoinColumn(name = "inv_id")
	private Inventory inventory;

	private int amount;

	public InventoryIngredient() {
		super();
	}

	public InventoryIngredientKey getInvIngKey() {
		return invIngKey;
	}

	public void setInvIngKey(InventoryIngredientKey invIngKey) {
		this.invIngKey = invIngKey;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "InventoryIngredient [invIngKey=" + invIngKey + ", ingredient=" + ingredient + ", inventory=" + inventory
				+ ", amount=" + amount + "]";
	}

}
