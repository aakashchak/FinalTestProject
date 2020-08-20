package com.intprojects.springboot.springsecurityapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intprojects.springboot.springsecurityapi.model.User;
import com.intprojects.springboot.springsecurityapi.repository.UserRepository;

@RestController
@RequestMapping("/secure/rest")
public class AdminController {
	
	@Autowired
	private UserRepository userRepository;
	
	private BCryptPasswordEncoder passwordEncoder;
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/admin/add") 
	public String addUserByAdmin(@RequestBody User user)
	{
		String pwd= user.getPassword();
		String encryptPwd=passwordEncoder.encode(pwd);
		user.setPassword(encryptPwd);
		return "user added successfully";
	}


	public UserRepository getUserRepository() {
		return userRepository;
	}


	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}
