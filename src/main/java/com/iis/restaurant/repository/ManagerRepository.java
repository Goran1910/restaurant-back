package com.iis.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iis.restaurant.model.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

}
