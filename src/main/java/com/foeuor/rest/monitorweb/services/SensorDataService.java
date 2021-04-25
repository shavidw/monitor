package com.foeuor.rest.monitorweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foeuor.rest.monitorweb.dto.SensorDataDTO;
import com.foeuor.rest.monitorweb.entity.SensorData;
import com.foeuor.rest.monitorweb.repositories.SensorDataRepository;

@Service
public class SensorDataService {
	
	@Autowired
	private SensorDataRepository sensorDataRepository;

	
	public boolean saveSensorData(SensorDataDTO sensorDataDTO) {
		SensorData sensorData = new SensorData();
		sensorData.setId(0l);
		sensorData.setSensorId(sensorDataDTO.getSensorId());
		sensorData.setReading(Double.parseDouble(sensorDataDTO.getDataValue()));
		sensorData.setAlertDate(sensorDataDTO.getDate());
		
		sensorDataRepository.save(sensorData);
		
		return true;
	}
	
	public List<SensorData> getSensorData(String sensorId) {
		return sensorDataRepository.findSensorDatasBySensorId(sensorId);
	}
	
}
