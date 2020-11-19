package com.capg.brs.service;

import java.util.List;
import java.util.Optional;

import com.capg.brs.entity.Bus;

public interface IBusService {
	public Bus addBus(Bus bus);

	public List<Bus> viewAllBuses();

	public Optional<Bus> viewBus(Long busId);

	public Bus modifyBus(Bus bus);

	public String removeBus(Long busId);
}
