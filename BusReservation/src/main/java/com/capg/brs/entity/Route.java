package com.capg.brs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="route8")
@Entity
public class Route {
	@Id
	private String routeId;
	private String source;
	private String destination;
	public String getRouteId() {
		return routeId;
	}
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
}
