package com.iis.restaurant.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Meal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "meal_id")
	private int id;
	@Column(name = "meal_name")
	private String name;
	@Column(name = "meal_desc")
	private String description;
	private int price;
	private MealType mealType;

	@ManyToOne
	@JoinColumn(name = "rest_id")
	private Restaurant restaurant;

	@OneToMany(mappedBy = "meal")
	private Set<PartyMeal> partyMeals = new HashSet<PartyMeal>();

	public Meal() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public MealType getMealType() {
		return mealType;
	}

	public void setMealType(MealType mealType) {
		this.mealType = mealType;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Set<PartyMeal> getPartyMeals() {
		return partyMeals;
	}

	public void setPartyMeals(Set<PartyMeal> partyMeals) {
		this.partyMeals = partyMeals;
	}

	@Override
	public String toString() {
		return "Meal [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", mealType="
				+ mealType + ", restaurant=" + restaurant + ", partyMeals=" + partyMeals + "]";
	}

}
