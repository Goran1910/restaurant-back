package com.iis.restaurant.service;

import java.util.List;

import com.iis.restaurant.dto.RestaurantDTO;

public interface RestaurantService {
	public List<RestaurantDTO> getAll(String username); 
}
