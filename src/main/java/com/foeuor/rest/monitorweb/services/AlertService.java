package com.foeuor.rest.monitorweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foeuor.rest.monitorweb.dto.SensorDataDTO;
import com.foeuor.rest.monitorweb.entity.Alert;
import com.foeuor.rest.monitorweb.entity.SensorData;
import com.foeuor.rest.monitorweb.entity.User;
import com.foeuor.rest.monitorweb.logics.TempSensorLogic;
import com.foeuor.rest.monitorweb.notifications.Email;
import com.foeuor.rest.monitorweb.notifications.PhoneCall;
import com.foeuor.rest.monitorweb.notifications.SMS;
import com.foeuor.rest.monitorweb.repositories.AlertRepository;
import com.foeuor.rest.monitorweb.repositories.UserRepository;

@Service
public class AlertService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AlertRepository alertRepository;
	
	public boolean checkIsAlert(SensorDataDTO sensorDataDTO) {
		
		boolean isAlert = false;
		
		if(sensorDataDTO.getSensorId().contains("TE")) {
			isAlert = new TempSensorLogic().checkTemp(Double.parseDouble(sensorDataDTO.getDataValue()));
		}
		
		if(isAlert) {
			
			List<User> availableUsers = userRepository.findUsersByIsAvailable(true);
			
			for(User user: availableUsers) {
				if(user.getNotificationType().equals("email")) {
					new Email().sendEmail();
				}
				
				if(user.getNotificationType().equals("call")) {
					new PhoneCall().getPhoneCall();
				}
				
				if(user.getNotificationType().equals("sms")) {
					new SMS().getSMS();
				}
			}
			
			Alert alert = new Alert();
			alert.setId(0L);
			alert.setSensorId(sensorDataDTO.getSensorId());
			alert.setReading(Double.parseDouble(sensorDataDTO.getDataValue()));
			alert.setAlertDate(sensorDataDTO.getDate());
			
			alertRepository.save(alert);
			
		}
		
		return true;
		
	}
	
	public List<Alert> getPastAlerts(){
		return alertRepository.findAll();
	}

}
