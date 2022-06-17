package com.iis.restaurant.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.iis.restaurant.dto.ManagerDTO;
import com.iis.restaurant.dto.UserRequest;
import com.iis.restaurant.model.Manager;
import com.iis.restaurant.model.Role;
import com.iis.restaurant.model.User;
import com.iis.restaurant.repository.ManagerRepository;
import com.iis.restaurant.repository.UserRepository;
import com.iis.restaurant.service.RoleService;
import com.iis.restaurant.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleService roleService;

	@Autowired
	private ManagerRepository managerRepository;

	@Override
	public User findByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}

	public User findById(Long id) throws AccessDeniedException {
		return userRepository.findById(id).orElseGet(null);
	}

	public List<User> findAll() throws AccessDeniedException {
		return userRepository.findAll();
	}

	public List<ManagerDTO> getAllManagers() {
		List<Manager> managers = this.managerRepository.findAll();
		List<ManagerDTO> dtos = new ArrayList<ManagerDTO>();
		for (Manager manager : managers) {
			dtos.add(manager.toDTO());
		}
		return dtos;
	}

	@Override
	public User save(UserRequest userRequest) {
		User u = new User();
		u.setUsername(userRequest.getUsername());

		// pre nego sto postavimo lozinku u atribut hesiramo je kako bi se u bazi
		// nalazila hesirana lozinka
		// treba voditi racuna da se koristi isi password encoder bean koji je
		// postavljen u AUthenticationManager-u kako bi koristili isti algoritam
		u.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		u.setEnabled(true);
		u.setEmail(userRequest.getEmail());

		// u primeru se registruju samo obicni korisnici i u skladu sa tim im se i
		// dodeljuje samo rola USER
		List<Role> roles = roleService.findByName("ROLE_CLIENT");
		u.setRoles(roles);

		return this.userRepository.save(u);
	}

}
