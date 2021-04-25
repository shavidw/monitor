package com.foeuor.rest.monitorweb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foeuor.rest.monitorweb.entity.SensorData;

public interface SensorDataRepository extends JpaRepository<SensorData, Long> {
	
	List<SensorData> findSensorDatasBySensorId(String sensorId);
}
