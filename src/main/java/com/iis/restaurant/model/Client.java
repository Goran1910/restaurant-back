package com.iis.restaurant.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client extends User {

	@JsonIgnore
	@OneToMany(mappedBy = "client")
	Set<TableReservation> tableReservations = new HashSet<TableReservation>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	Set<Rating> ratings = new HashSet<Rating>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	Set<Comment> comments = new HashSet<Comment>();

	public Client(Set<TableReservation> tableReservations) {
		super();
		this.tableReservations = tableReservations;
	}

	public Client() {
		super();
	}

	public Set<TableReservation> getTableReservations() {
		return tableReservations;
	}

	public void setTableReservations(Set<TableReservation> tableReservations) {
		this.tableReservations = tableReservations;
	}

	public Set<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Client [tableReservations=" + tableReservations + ", ratings=" + ratings + ", comments=" + comments
				+ "]";
	}

}
