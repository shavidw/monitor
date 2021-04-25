package com.foeuor.rest.monitorweb.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SensorDataDTO {
	
	private String sensorId;
	private LocalDateTime date;
	private String dataValue;
	
	public String getSensorId() {
		return sensorId;
	}
	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public LocalDateTime getDate() {
		return date;
	}
	
	public String getDataValue() {
		return dataValue;
	}
	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}


}
