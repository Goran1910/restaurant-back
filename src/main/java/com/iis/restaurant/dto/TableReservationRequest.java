package com.iis.restaurant.dto;

import java.sql.Timestamp;

public class TableReservationRequest {
	private int numOfPeople;
	private Timestamp date;
	private String restaurantName;

	public TableReservationRequest() {
		super();
	}

	public int getNumOfPeople() {
		return numOfPeople;
	}

	public void setNumOfPeople(int numOfPeople) {
		this.numOfPeople = numOfPeople;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	@Override
	public String toString() {
		return "TableReservationRequest [numOfPeople=" + numOfPeople + ", date=" + date + ", restaurantName="
				+ restaurantName + "]";
	}

}
