package com.capg.brs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.brs.entity.Route;

@Repository
public interface IRouteRepository extends JpaRepository<Route, String> {

	@Query("select routeId from Route u where u.source=?1 and u.destination=?1")
	public Route findBySourceAndDestination(String source,String destination);

}
