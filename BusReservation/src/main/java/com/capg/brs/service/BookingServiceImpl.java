package com.capg.brs.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.brs.entity.Booking;
import com.capg.brs.entity.Bus;
import com.capg.brs.entity.Route;
import com.capg.brs.entity.Schedule;
import com.capg.brs.entity.User;
import com.capg.brs.exceptions.BookingNotFoundException;
import com.capg.brs.exceptions.RouteDoesNotExistsException;
import com.capg.brs.exceptions.ScheduleDoesNotExistsException;
import com.capg.brs.repository.IBookingRepository;
import com.capg.brs.repository.IBusRepository;
import com.capg.brs.repository.IRouteRepository;
import com.capg.brs.repository.IScheduleRepository;

@Service
public class BookingServiceImpl implements IBookingService {

	
	@Autowired
	IBookingRepository bookingRepository;
	@Autowired
	IRouteRepository routeRepository;
	@Autowired
	IScheduleRepository scheduleRepository;
	@Autowired
	IBusRepository busRepository;
	
	@Override
	public Booking addBooking(User user,String source,String destination,LocalDate dateOfJourney,Integer noOfPassengers) {
    Route   routeId=routeRepository.findBySourceAndDestination(source,destination);
     if(routeId==null)
    	 throw new RouteDoesNotExistsException("Route not found");
     else {
    	Schedule schedule=scheduleRepository.findByRouteIdAndArrivalTime(routeId,dateOfJourney);
    	 if(schedule==null)
    		 throw new ScheduleDoesNotExistsException("No buses available");
    	 else {
    		
    	 }
    	 }
    
   
		return (Booking) bookingRepository;
	}

	@Override
	public Booking getBookingById(Long bookingId) {
		if (!bookingRepository.existsById(bookingId)) {
			throw new BookingNotFoundException(" booking not found");
		}
		return bookingRepository.getBooking(bookingId);
	}

	@Override
	public List<Booking> getAllBookings() {
		
			return bookingRepository.findAll();
		
	}

	@Override
	public void deleteBooking(Long bookingId) {
		if(!bookingRepository.existsById(bookingId)) {
			 throw new BookingNotFoundException("BookingId with "+bookingId+" is NOT FOUND");
		 }
		 bookingRepository.deleteById(bookingId);
	}

}
