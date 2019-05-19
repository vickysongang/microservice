package com.sa.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sa.ribbon.service.HelloService;

@RestController
public class HelloController {
	@Autowired
	private HelloService service;

	@RequestMapping("/hello")
	public String sayHello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return service.sayHello(name);
	}

	@RequestMapping("/info")
	public String info() {
		return service.info();
	}
	
	@RequestMapping("/instance")
	public void logInstance() {
		service.logInstance();
	}
}
