package com.iis.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iis.restaurant.dto.RestaurantDTO;
import com.iis.restaurant.dto.TableReservationRequest;
import com.iis.restaurant.service.RestaurantService;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {
	private RestaurantService restaurantService;

	@Autowired
	public RestaurantController(RestaurantService restaurantService) {
		super();
		this.restaurantService = restaurantService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<RestaurantDTO>> getAll() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		List<RestaurantDTO> dtos = this.restaurantService.getAll(username);
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

	@PostMapping("/createTableReservation")
	public ResponseEntity<Boolean> createReservation(@RequestBody TableReservationRequest request) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Boolean success = this.restaurantService.validateReservationTableRequest(username, request);
		if(success) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
	}

}
