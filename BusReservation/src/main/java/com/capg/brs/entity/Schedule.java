package com.capg.brs.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name="schedule8")
@Entity
public class Schedule {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long scheduleId;
	@ManyToOne
	private Bus busId;
	@ManyToOne
	private Route route;
	private LocalDateTime arrivalTime;
	private LocalDateTime departureTime;
	
	
	public Long getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}
	
	public Bus getBusId() {
		return busId;
	}
	public void setBusId(Bus busId) {
		this.busId = busId;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
}
