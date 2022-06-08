package com.iis.restaurant.service;

import java.util.List;

import com.iis.restaurant.model.Role;

public interface RoleService {
	Role findById(Long id);
	List<Role> findByName(String name);
}
