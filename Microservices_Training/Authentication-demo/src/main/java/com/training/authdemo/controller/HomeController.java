package com.training.authdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/greet")
	public String greet() {
		return "Good Morning";
	}

	
	@GetMapping("/admin/page")
	public String adminpage() {
		return "Good Morning Admin";
	}
	
	@GetMapping("/user/page")
	public String userpage() {
		return "Good Morning User";
	}
}
