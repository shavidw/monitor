package com.foeuor.rest.monitorweb.dto;

import java.time.LocalDate;

public class SensorDataDTO {
	
	private String sensorId;
	private LocalDate date;
	private String dataValue;
	
	public String getSensorId() {
		return sensorId;
	}
	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getDataValue() {
		return dataValue;
	}
	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}

}
