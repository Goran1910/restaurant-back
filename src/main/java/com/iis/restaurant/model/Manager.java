package com.iis.restaurant.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iis.restaurant.dto.ManagerDTO;

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
	
	public ManagerDTO toDTO() {
		List<String> names = this.getRestaurantNames();
		return new ManagerDTO(this.username, this.email, names);
	}
	
	public List<String> getRestaurantNames() {
		List<String> names = new ArrayList<String>();
		for(Restaurant r : this.restaurants) {
			names.add(r.getName());
		}
		return names;
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
