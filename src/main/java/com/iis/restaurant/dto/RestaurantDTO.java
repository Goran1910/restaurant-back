package com.iis.restaurant.dto;

public class RestaurantDTO {

	private String name;
	private String imagePath;
	private float averageRating;
	private int yourRating;

	public RestaurantDTO(String name, String imagePath, float averageRating, int yourRating) {
		super();
		this.name = name;
		this.imagePath = imagePath;
		this.averageRating = averageRating;
		this.yourRating = yourRating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public float getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(float averageRating) {
		this.averageRating = averageRating;
	}

	public int getYourRating() {
		return yourRating;
	}

	public void setYourRating(int yourRating) {
		this.yourRating = yourRating;
	}

	@Override
	public String toString() {
		return "RestaurantDTO [name=" + name + ", imagePath=" + imagePath + ", averageRating=" + averageRating
				+ ", yourRating=" + yourRating + "]";
	}

}
