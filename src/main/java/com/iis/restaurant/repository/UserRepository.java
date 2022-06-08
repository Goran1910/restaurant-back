package com.iis.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iis.restaurant.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

