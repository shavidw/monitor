package com.foeuor.rest.monitorweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foeuor.rest.monitorweb.entity.User;

import com.foeuor.rest.monitorweb.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public boolean registerUser(User user) {
		
		if(userRepository.existsByUsername(user.getUsername())) {
			return false;
		}else {
			user.setNotificationType("email");
			user.setIsAvailable(true);
			userRepository.save(user);
			return true;
		}
	}
	
	public boolean loginUser(User user) {
		return userRepository.existsByUsernameAndPassword(user.getUsername(), user.getPassword());
	}
}
