package com.capg.brs.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.brs.entity.Schedule;
import com.capg.brs.repository.IScheduleRepository;
@Service
@Transactional
public class ScheduleServiceImpl implements IScheduleService {

	@Autowired
	IScheduleRepository dao;
	
	@Override
	public Schedule addBusSchedule(Schedule schedule) {
		
		return dao.save(schedule);
	}

	@Override
	public Schedule modifyBusSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		return dao.save(schedule);
	}

	@Override
	public Optional<Schedule> viewBusScheduleById(Long busId) {
		// TODO Auto-generated method stub
		return dao.findById(busId);
	}

	@Override
	public List<Schedule> viewAllBusSchedules() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void deleteBusSchedule(Long ScheduleId) {
		// TODO Auto-generated method stub
		dao.deleteById(ScheduleId);
	}

}
