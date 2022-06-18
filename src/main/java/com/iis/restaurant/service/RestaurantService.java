package com.iis.restaurant.service;

import java.util.List;

import com.iis.restaurant.dto.DayReservationStat;
import com.iis.restaurant.dto.RestaurantDTO;
import com.iis.restaurant.dto.TableReservationRequest;

public interface RestaurantService {
	public List<RestaurantDTO> getAll(String username);

	public Boolean createReservation(String username, int tableId, TableReservationRequest request);
	
	public Boolean validateReservationTableRequest(String username, TableReservationRequest request);

	public List<DayReservationStat> getStatsByRestName(String restName);
}
