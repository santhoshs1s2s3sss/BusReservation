package com.capg.brs.service;

import java.util.List;
import java.util.Optional;

import com.capg.brs.entity.Booking;
import com.capg.brs.entity.Route;

public interface IRouteService {
	 public Route addRoute(Route route);
	  public List<Route> getAllRoutes();
	  public void deleteRoute(String routeId);
	  public Route modifyroute(Route route);
	
}
