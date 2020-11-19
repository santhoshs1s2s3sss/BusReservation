package com.capg.brs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.brs.entity.Route;
import com.capg.brs.exceptions.BookingNotFoundException;
import com.capg.brs.repository.IRouteRepository;

@Service
public class RouteServiceImpl implements IRouteService{
	@Autowired
	IRouteRepository routeRepository;
	@Override
	public Route addRoute(Route route) {
		Route r = routeRepository.save(route);
		return r;
	}

	@Override
	public List<Route> getAllRoutes() {
//		List<Route> list = routeRepository.findAll();
		return routeRepository.findAll();
	}

	@Override
	public void deleteRoute(String routeId) {
		if(!routeRepository.existsById(routeId)) {
			 throw new BookingNotFoundException("RouteId with "+routeId+" is NOT FOUND");
		 }
		 routeRepository.deleteById(routeId);
	}

	@Override
	public Route modifyroute(Route route) {
		// TODO Auto-generated method stub
		return routeRepository.save(route);
	}

		
	}

