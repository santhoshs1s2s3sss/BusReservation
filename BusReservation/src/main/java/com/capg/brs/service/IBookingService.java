package com.capg.brs.service;

import java.time.LocalDate;
import java.util.List;
import com.capg.brs.entity.Booking;
import com.capg.brs.entity.User;

public interface IBookingService {

	
	  public Booking addBooking(User user,String source,String destination,LocalDate dateOfJourney,Integer noOfPassengers);
	  public Booking getBookingById(Long bookingId);
	  public List<Booking> getAllBookings();
	  public void deleteBooking(Long bookingId);
}
