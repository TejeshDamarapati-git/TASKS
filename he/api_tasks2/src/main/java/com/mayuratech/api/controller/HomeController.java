package com.mayuratech.api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class HomeController {

	@GetMapping("/home")
	public String view(){
		return "Welcome to Angular Login Project";
		}
}
