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
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rest_id")
	private int id;

	@Column(name = "rest_name", length = 30)
	private String name;

	@OneToMany(mappedBy = "restaurant")
	Set<TableEntity> tables = new HashSet<TableEntity>();

	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Manager manager;

	@OneToMany(mappedBy = "restaurant")
	Set<Rating> ratings = new HashSet<Rating>();

	@OneToMany(mappedBy = "restaurant")
	Set<Comment> comments = new HashSet<Comment>();

	public Restaurant(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Restaurant() {
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

	public Set<TableEntity> getTables() {
		return tables;
	}

	public void setTables(Set<TableEntity> tables) {
		this.tables = tables;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
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
		return "Restaurant [id=" + id + ", name=" + name + ", tables=" + tables + ", manager=" + manager + ", ratings="
				+ ratings + ", comments=" + comments + "]";
	}

}
