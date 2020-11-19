package com.capg.brs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.brs.entity.Booking;
import com.capg.brs.entity.Route;
import com.capg.brs.service.BookingServiceImpl;
import com.capg.brs.service.RouteServiceImpl;

@RestController
	@RequestMapping("/route")
public class RouteController {
		@Autowired
		RouteServiceImpl routeService;
		
		@PostMapping(value="/addRoute")
		public ResponseEntity<String> addRoute(@RequestBody Route route){
		    Route ro = routeService.addRoute(route);
		    if(ro != null)
		    	return new ResponseEntity<String>("route was added successfully!!",HttpStatus.OK);
		    else
		    	return new ResponseEntity<String>("sorry, problem while adding route!!", HttpStatus.OK);
		}
		
		@GetMapping("/allRoute")
		public ResponseEntity<List<Route>> getAllRoute(){
			List<Route> allRoute=routeService.getAllRoutes();
			return new ResponseEntity<List<Route>>(allRoute,HttpStatus.OK);
		}
		
		@DeleteMapping("/{routeId}")
		public ResponseEntity<Route> deleteRoute(@Valid @PathVariable String routeId){
			routeService.deleteRoute(routeId);
			return new ResponseEntity<Route>(HttpStatus.OK);
}
		
		@PutMapping("/modify")
		public ResponseEntity<Route> modify(@RequestBody Route route){
			Route r = routeService.modifyroute(route);
			return new ResponseEntity<>(r,HttpStatus.OK);
		}


	

}
