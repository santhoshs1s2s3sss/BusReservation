package com.capg.brs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.brs.entity.Booking;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Long> {


	@Query("SELECT b FROM Booking b WHERE bookingId = ?1")
	public Booking getBooking(Long bookingId);

}
