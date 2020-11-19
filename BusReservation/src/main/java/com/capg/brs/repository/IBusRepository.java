package com.capg.brs.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.brs.entity.Bus;
import com.capg.brs.entity.Route;
import com.capg.brs.entity.Schedule;


@Repository
public interface IBusRepository extends JpaRepository<Bus, Long> {

	
	@Query("select fare from Bus b where busId=?1")
	Bus findFareByBusId(Schedule schedule);
	
}
