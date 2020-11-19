package com.capg.brs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.brs.entity.Booking;
import com.capg.brs.service.BookingServiceImpl;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	
	@Autowired
	BookingServiceImpl bookingService;
	
	
	@GetMapping("/{bookingId}")
	public ResponseEntity<Booking> getBookingById(@PathVariable Long bookingId) {

		Booking b = bookingService.getBookingById(bookingId);

		return new ResponseEntity<Booking>(b, HttpStatus.OK);
	}
	
	@GetMapping("/allBookings")
	public ResponseEntity<List<Booking>> getAllBookings() {
		List<Booking> allBooking= bookingService.getAllBookings();
		return new ResponseEntity<List<Booking>>(allBooking, HttpStatus.OK);
	}
	
	@DeleteMapping("/{bookingId}")
	public ResponseEntity<Booking> deleteBooking(@Valid @PathVariable Long bookingId) {
		bookingService.deleteBooking(bookingId);
		return new ResponseEntity<Booking>(HttpStatus.OK);

	}
}
