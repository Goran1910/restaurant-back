package com.iis.restaurant.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iis.restaurant.dto.DayReservationStat;
import com.iis.restaurant.model.TableReservation;

@Repository
public interface TableReservationRepository extends JpaRepository<TableReservation, Long> {

	@Query(value = "select * \r\n" + "from table_reservation\r\n" + "where table_id = :table_id \r\n"
			+ "and ((reservation_date >= :requested_date\r\n"
			+ "and reservation_date <= date_add(:requested_date, interval 1 HOUR))) \r\n"
			+ "or ((date_add(reservation_date, interval 1 HOUR) >= :requested_date\r\n"
			+ "and date_add(reservation_date, interval 1 HOUR) < date_add(:requested_date, interval 1 HOUR)));", nativeQuery = true)
	public List<TableReservation> getInBetweenReservations(@Param("table_id") int tableId,
			@Param("requested_date") Timestamp requestedDate);

	@Query(value = "select count(*) as \"numOfReservations\", sum(num_of_people) as \"numOfPeople\", rest_id as restaurantName, day(reservation_date) as day\r\n"
			+ "from table_reservation natural join table_entity\r\n" + "where month(reservation_date) = :month and rest_id = :rest_name\r\n"
			+ "group by day(reservation_date) order by day;", nativeQuery = true)
	public List<DayReservationStat> dailyStats(@Param("rest_name") String restName, @Param("month") int month);
}
