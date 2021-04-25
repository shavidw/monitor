package com.foeuor.rest.monitorweb.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sensor_data")
public class SensorData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String sensorId;
	private double reading;
	private LocalDate alertDate;
	private LocalTime alertTime;
	
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}
	
	public String getSensorId() {
		
		
		return sensorId;
	}
	public double getReading() {
		return reading;
	}
	public void setReading(double reading) {
		this.reading = reading;
	}
	
	public LocalDate getAlertDate() {
		return alertDate;
	}
	public void setAlertDate(LocalDate alertDate) {
		this.alertDate = alertDate;
	}
	public LocalTime getAlertTime() {
		return alertTime;
	}
	
	public void setAlertTime(LocalTime alertTime) {
		
		this.alertTime = alertTime;
	}

}
