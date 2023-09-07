package com.sun.oauthback.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@GetMapping("")
	public String get() {
		return "Server On...";
	}

}
