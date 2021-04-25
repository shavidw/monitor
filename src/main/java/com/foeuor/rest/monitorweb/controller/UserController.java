package com.foeuor.rest.monitorweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foeuor.rest.monitorweb.entity.User;
import com.foeuor.rest.monitorweb.services.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public boolean registerUser(@RequestBody User user) {
		return userService.registerUser(user);
	}
	
	@PostMapping("/login")
	public boolean loginUser(@RequestBody User user) {
		return userService.loginUser(user);
	}
}
