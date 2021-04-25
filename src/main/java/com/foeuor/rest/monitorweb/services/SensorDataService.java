package com.foeuor.rest.monitorweb.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foeuor.rest.monitorweb.dto.SensorDataDTO;
import com.foeuor.rest.monitorweb.dto.SensorGraphDTO;
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
	
	public List<SensorGraphDTO> getSensorData(String sensorId) {
		return sensorDataRepository.findSensorDatasBySensorId(sensorId)
				.stream()
				.map(e -> new SensorGraphDTO(e.getAlertDate().toString(), e.getReading()))
				.collect(Collectors.toList());
	}
	
}
