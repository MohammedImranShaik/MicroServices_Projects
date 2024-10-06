package com.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.client.WelcomeFeignClient;

@RestController
public class GreetRestController {

	@Autowired
	private WelcomeFeignClient welcomeFeignClient;

	@GetMapping("/greet")
	public String getGreeting() {
		String welcomeMsg = welcomeFeignClient.getWelcomeMsg();
		String greetMsg = "Hey!, Buddie Welcome to ";
		return greetMsg + welcomeMsg;
	}

}
