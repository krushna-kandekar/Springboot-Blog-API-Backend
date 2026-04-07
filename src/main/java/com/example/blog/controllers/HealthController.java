package com.example.blog.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HealthController {

	@PostMapping("/health")
	public String getHealth() {
		return "Application is running fine";
	}
}
