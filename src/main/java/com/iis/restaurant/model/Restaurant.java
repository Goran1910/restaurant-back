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

import com.iis.restaurant.dto.RestaurantDTO;

@Entity
public class Restaurant {

	@Id
	@Column(name = "rest_name", length = 30)
	private String name;

	private String imagePath;

	@OneToMany(mappedBy = "restaurant")
	Set<TableEntity> tables = new HashSet<TableEntity>();

	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Manager manager;

	@OneToMany(mappedBy = "restaurant")
	Set<Rating> ratings = new HashSet<Rating>();

	@OneToMany(mappedBy = "restaurant")
	Set<Comment> comments = new HashSet<Comment>();

	public Restaurant() {
		super();
	}

	public RestaurantDTO toDTO(String username) {
		float averageRating = this.calculateAverageRating();
		int clientsRating = this.getClientsRating(username);
		return new RestaurantDTO(this.name, this.imagePath, averageRating, clientsRating);
	}

	public float calculateAverageRating() {
		int sum = 0;
		for (Rating r : this.ratings) {
			sum += r.getValue();
		}
		return sum / this.ratings.size();
	}

	public int getClientsRating(String username) {
		for (Rating r : this.ratings) {
			if (r.getClient().getUsername().equals(username)) {
				return r.getValue();
			}
		}
		return 0;
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", imagePath=" + imagePath + ", tables=" + tables + ", manager=" + manager
				+ ", ratings=" + ratings + ", comments=" + comments + "]";
	}

}
