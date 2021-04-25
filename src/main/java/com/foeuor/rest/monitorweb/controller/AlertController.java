package com.foeuor.rest.monitorweb.controller;

import java.util.ArrayList;
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
import com.foeuor.rest.monitorweb.entity.Alert;
import com.foeuor.rest.monitorweb.entity.SensorData;
import com.foeuor.rest.monitorweb.entity.User;
import com.foeuor.rest.monitorweb.logics.TempSensorLogic;
import com.foeuor.rest.monitorweb.notifications.Email;
import com.foeuor.rest.monitorweb.notifications.PhoneCall;
import com.foeuor.rest.monitorweb.notifications.SMS;
import com.foeuor.rest.monitorweb.repositories.AlertRepository;
import com.foeuor.rest.monitorweb.services.AlertService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/alerts")
public class AlertController {
	
	@Autowired
	private AlertService alertService;
	
	@GetMapping
	public List<Alert> getPastAlerts(){
		return alertService.getPastAlerts();
	}
	
	
}
