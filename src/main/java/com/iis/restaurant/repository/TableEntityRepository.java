package com.iis.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iis.restaurant.model.TableEntity;

@Repository
public interface TableEntityRepository extends JpaRepository<TableEntity, Integer> {
	
	@Query(value = "select * from table_entity where rest_id = :rest_name and capacity >= :minNumOfPeople and capacity <= :maxNumOfPeople",
			nativeQuery = true)
	public List<TableEntity> getAllTablesBySeatsSortedBySeats(@Param("minNumOfPeople") int minNumOfPeople,
			@Param("maxNumOfPeople") int maxNumOfPeople,
			@Param("rest_name") String restName);
	
	public TableEntity findById(int id);
}
