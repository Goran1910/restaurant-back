package com.iis.restaurant.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iis.restaurant.dto.RestaurantDTO;
import com.iis.restaurant.model.Restaurant;
import com.iis.restaurant.repository.RestaurantRepository;
import com.iis.restaurant.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	private RestaurantRepository restaurantRepository;

	@Autowired
	public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
		super();
		this.restaurantRepository = restaurantRepository;
	}

	public List<RestaurantDTO> getAll(String username) {
		List<Restaurant> restaurants = this.restaurantRepository.findAll();
		List<RestaurantDTO> dtos = new ArrayList<RestaurantDTO>();
		for(Restaurant r : restaurants) {
			dtos.add(r.toDTO(username));
		}
		return dtos;
	}
}
