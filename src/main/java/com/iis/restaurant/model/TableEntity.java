package com.iis.restaurant.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TableEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "table_id")
	private int id;
	private int capacity;

	@ManyToOne
	@JoinColumn(name = "rest_id")
	Restaurant restaurant;

	@OneToMany(mappedBy = "table")
	Set<TableReservation> tableReservations = new HashSet<TableReservation>();

	@ManyToMany
	Set<Party> parties = new HashSet<Party>();

	public TableEntity(int id, int capacity) {
		super();
		this.id = id;
		this.capacity = capacity;
	}

	public TableEntity() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Set<TableReservation> getTableReservations() {
		return tableReservations;
	}

	public void setTableReservations(Set<TableReservation> tableReservations) {
		this.tableReservations = tableReservations;
	}

	public Set<Party> getParties() {
		return parties;
	}

	public void setParties(Set<Party> parties) {
		this.parties = parties;
	}

	@Override
	public String toString() {
		return "TableEntity [id=" + id + ", capacity=" + capacity + ", restaurant=" + restaurant
				+ ", tableReservations=" + tableReservations + ", parties=" + parties + "]";
	}

}
