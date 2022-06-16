package com.iis.restaurant.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Manager extends User {
	
	@JsonIgnore
	@OneToMany(mappedBy = "manager")
	private Set<Restaurant> restaurants = new HashSet<Restaurant>();

	public Manager() {
		super();
	}

	public Manager(Set<Restaurant> restaurants) {
		super();
		this.restaurants = restaurants;
	}

	public Set<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(Set<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	@Override
	public String toString() {
		return "Manager [restaurants=" + restaurants + "]";
	}

}
