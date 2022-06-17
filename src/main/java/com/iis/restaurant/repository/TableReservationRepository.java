package com.iis.restaurant.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iis.restaurant.model.TableReservation;

@Repository
public interface TableReservationRepository extends JpaRepository<TableReservation, Long> {
	
	@Query(value = "select * \r\n"
			+ "from table_reservation\r\n"
			+ "where table_id = :table_id \r\n"
			+ "and ((reservation_date >= :requested_date\r\n"
			+ "and reservation_date <= date_add(:requested_date, interval 1 HOUR))) \r\n"
			+ "or ((date_add(reservation_date, interval 1 HOUR) >= :requested_date\r\n"
			+ "and date_add(reservation_date, interval 1 HOUR) < date_add(:requested_date, interval 1 HOUR)));",
			nativeQuery = true)
	public List<TableReservation> getInBetweenReservations(@Param("table_id") int tableId,
			@Param("requested_date") Timestamp requestedDate);
}
