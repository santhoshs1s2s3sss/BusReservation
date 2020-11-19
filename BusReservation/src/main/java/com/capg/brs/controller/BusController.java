package com.capg.brs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.brs.entity.Bus;
import com.capg.brs.service.IBusService;

@RestController
@RequestMapping("/bus")
public class BusController {
	
	@Autowired
	IBusService service;

	@PostMapping("/addBus")
	public ResponseEntity<Bus> addBus(@RequestBody Bus bus){
		Bus b = service.addBus(bus);
		return new ResponseEntity<>(b,HttpStatus.OK);
	}
	
	@GetMapping("/gettAllBuses")
	public ResponseEntity<List<Bus>> getAllBuses(){
		List<Bus> list = service.viewAllBuses();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/viewBus/{busId}")
	public ResponseEntity<Optional<Bus>> viewBus(@PathVariable("busId")Long busId){
		Optional<Bus> b = service.viewBus(busId);
		return new ResponseEntity<>(b,HttpStatus.OK);
	}
	
	@PutMapping("/modifyBus")
	public ResponseEntity<Bus> modifyBuse(@RequestBody Bus bus){
		Bus b = service.modifyBus(bus);
		return new ResponseEntity<>(b,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteBus/{busId}")
	public ResponseEntity<String> deleteBus(@PathVariable("busId")Long busId){
		String string = service.removeBus(busId);
		return new ResponseEntity<>(string,HttpStatus.OK);
	}
}
