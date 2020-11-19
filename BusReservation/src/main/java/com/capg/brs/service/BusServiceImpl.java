package com.capg.brs.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.brs.entity.Bus;
import com.capg.brs.repository.IBusRepository;

@Service
@Transactional
public class BusServiceImpl implements IBusService{
	
	@Autowired
	IBusRepository dao;

	@Override
	public Bus addBus(Bus bus) {
		// TODO Auto-generated method stub
		return dao.save(bus);
	}

	@Override
	public List<Bus> viewAllBuses() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Bus> viewBus(Long busId) {
		// TODO Auto-generated method stub
		return dao.findById(busId);
	}

	@Override
	public Bus modifyBus(Bus bus) {
		// TODO Auto-generated method stub
		return dao.save(bus);
	}

	@Override
	public String removeBus(Long busId) {
		// TODO Auto-generated method stub
		dao.deleteById(busId);
		return "deleted successfully!!";
	}

}
