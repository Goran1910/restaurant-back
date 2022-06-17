package com.iis.restaurant.dto;

import java.util.List;

public class ManagerDTO {
	private String username;
	private String email;
	private List<String> restaurantNames;

	public ManagerDTO(String username, String email, List<String> restaurantNames) {
		super();
		this.username = username;
		this.email = email;
		this.restaurantNames = restaurantNames;
	}

	public ManagerDTO() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRestaurantNames() {
		return restaurantNames;
	}

	public void setRestaurantNames(List<String> restaurantNames) {
		this.restaurantNames = restaurantNames;
	}

	@Override
	public String toString() {
		return "ManagerDTO [username=" + username + ", email=" + email + ", restaurantNames=" + restaurantNames + "]";
	}

}
