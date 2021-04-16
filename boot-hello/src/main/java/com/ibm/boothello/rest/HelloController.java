package com.ibm.boothello.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello Spring Boot";
	}
	@GetMapping(value = "/hola" ,produces = "text/html")
	public String sayHola() {
		return "<h1>Hola spring Boot</h1>";
	}
	
	@GetMapping(value = "/haii", produces = "application/json")
	public String sayHaii() {
		return "{\"greeting\":\"Haii Spring Bott\"}";
	}
}
