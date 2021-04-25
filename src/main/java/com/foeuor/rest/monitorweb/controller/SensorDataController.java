package com.foeuor.rest.monitorweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foeuor.rest.monitorweb.dto.SensorDataDTO;
import com.foeuor.rest.monitorweb.entity.SensorData;
import com.foeuor.rest.monitorweb.services.SensorDataService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/sensors")
public class SensorDataController {
	
	@Autowired
	private SensorDataService sensorDataService;
	
	
	@PostMapping
	public boolean saveSensorData(@RequestBody SensorDataDTO sensorDataDTO) {
		return sensorDataService.saveSensorData(sensorDataDTO);
	}
	
	@GetMapping("/{id}")
	public List<SensorData> getSensorData(@PathVariable("id") String sensorId) {
		return sensorDataService.getSensorData(sensorId);
	}

}
