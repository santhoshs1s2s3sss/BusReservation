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

import com.capg.brs.entity.Schedule;
import com.capg.brs.service.IScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	IScheduleService service;
	
	@PostMapping("/addSchedule")
	public ResponseEntity<Schedule>addSchedule(@RequestBody Schedule schedule){
		Schedule schedule2 = service.addBusSchedule(schedule);
		return new ResponseEntity<>(schedule2,HttpStatus.OK);
	}
	
	@PutMapping("/modify")
	public ResponseEntity<Schedule>modify(@RequestBody Schedule schedule){
		Schedule schedule2 = service.modifyBusSchedule(schedule);
		return new ResponseEntity<>(schedule2,HttpStatus.OK);
	}
	
	@GetMapping("/getBus/{busId}")
	public ResponseEntity<Optional<Schedule>> findBus(@PathVariable("busId") Long busId){
		Optional<Schedule> schedule2 = service.viewBusScheduleById(busId);
		return new ResponseEntity<>(schedule2,HttpStatus.OK);
	}
	
	@GetMapping("listAll")
	public ResponseEntity<List<Schedule>> listAll(){
		List<Schedule> list = service.viewAllBusSchedules();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<String> delete(@PathVariable("busId") Long busId){
		service.deleteBusSchedule(busId);
		return new ResponseEntity<>("deletedd successfully!!",HttpStatus.OK);
	}
}
