package com.iis.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iis.restaurant.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

}
