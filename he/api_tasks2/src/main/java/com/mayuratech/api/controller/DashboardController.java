package com.mayuratech.api.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mayuratech.api.entity.User;
import com.mayuratech.api.repository.UserRepository;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class DashboardController {
	
	 @Autowired
	    private UserRepository userRepository;


	@GetMapping("/dashboard")
    public List<User> getDashboardData() {
		return userRepository.findAll();
    }
	
}
