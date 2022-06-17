package com.iis.restaurant.service;

import java.util.List;

import com.iis.restaurant.dto.ManagerDTO;
import com.iis.restaurant.dto.UserRequest;
import com.iis.restaurant.model.User;

public interface UserService {
	User findById(Long id);

	User findByUsername(String username);

	List<User> findAll();

	User save(UserRequest userRequest);

	public List<ManagerDTO> getAllManagers();
}
