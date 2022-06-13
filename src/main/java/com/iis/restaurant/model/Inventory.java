package com.iis.restaurant.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Inventory {
	@Id
	@Column(name = "inv_name")
	private String name;

	@OneToMany(mappedBy = "inventory")
	private Set<InventoryIngredient> invIngs = new HashSet<InventoryIngredient>();

	public Inventory() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<InventoryIngredient> getInvIngs() {
		return invIngs;
	}

	public void setInvIngs(Set<InventoryIngredient> invIngs) {
		this.invIngs = invIngs;
	}

	@Override
	public String toString() {
		return "Inventory [name=" + name + ", invIngs=" + invIngs + "]";
	}

}
