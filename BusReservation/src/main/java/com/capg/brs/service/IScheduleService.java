package com.capg.brs.service;

import java.util.List;
import java.util.Optional;

import com.capg.brs.entity.Schedule;

public interface IScheduleService {

	public Schedule addBusSchedule(Schedule schedule);
	  public Schedule modifyBusSchedule(Schedule schedule);
	  public Optional<Schedule> viewBusScheduleById(Long busId);
	  public List<Schedule> viewAllBusSchedules();
	  public void deleteBusSchedule(Long ScheduleId);
}
