package com.iis.restaurant.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iis.restaurant.dto.RestaurantDTO;
import com.iis.restaurant.dto.TableReservationRequest;
import com.iis.restaurant.model.Client;
import com.iis.restaurant.model.Restaurant;
import com.iis.restaurant.model.TableEntity;
import com.iis.restaurant.model.TableReservation;
import com.iis.restaurant.repository.ClientRepository;
import com.iis.restaurant.repository.RestaurantRepository;
import com.iis.restaurant.repository.TableEntityRepository;
import com.iis.restaurant.repository.TableReservationRepository;
import com.iis.restaurant.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	private RestaurantRepository restaurantRepository;
	private TableEntityRepository tableEntityRepository;
	private TableReservationRepository tableReservationRepository;
	private ClientRepository clientReposiotry; 

	@Autowired
	public RestaurantServiceImpl(RestaurantRepository restaurantRepository,
			TableEntityRepository tableEntityRepository,
			TableReservationRepository tableReservationRepository,
			ClientRepository clientReposiotry) {
		super();
		this.restaurantRepository = restaurantRepository;
		this.tableEntityRepository = tableEntityRepository;
		this.tableReservationRepository = tableReservationRepository;
		this.clientReposiotry = clientReposiotry;
	}

	public List<RestaurantDTO> getAll(String username) {
		List<Restaurant> restaurants = this.restaurantRepository.findAll();
		List<RestaurantDTO> dtos = new ArrayList<RestaurantDTO>();
		for (Restaurant r : restaurants) {
			dtos.add(r.toDTO(username));
		}
		return dtos;
	}

	public Boolean validateReservationTableRequest(String username, TableReservationRequest request) {
		List<TableEntity> tables = this.tableEntityRepository.getAllTablesBySeatsSortedBySeats(request.getNumOfPeople(), request.getNumOfPeople() + 2, request.getRestaurantName());
		for(TableEntity table : tables) {
			List<TableReservation> reservations = this.tableReservationRepository.getInBetweenReservations(table.getId(), request.getDate());
			if(reservations.size() == 0) {
				this.createReservation(username, table.getId(), request);
				return true;
			}
		}
		return false;
	}
	
	public Boolean createReservation(String username, int tableId, TableReservationRequest request) {
		TableReservation reservation = new TableReservation();
		reservation.setNumOfPeople(request.getNumOfPeople());
		reservation.setDate(request.getDate());
		TableEntity table = this.tableEntityRepository.findById(tableId);
		reservation.setTable(table);
		Client client = clientReposiotry.findByUsername(username);
		reservation.setClient(client);
		this.tableReservationRepository.save(reservation);
		return true;
	}
}
