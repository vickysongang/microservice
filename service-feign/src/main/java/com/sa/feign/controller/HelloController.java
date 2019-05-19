package com.sa.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sa.feign.service.HelloService;

@RestController
public class HelloController {
	@Autowired
	private HelloService service;

	@RequestMapping("/hello")
	public String sayHello(@RequestParam(value = "name", required = false) String name) {
		return service.sayHelloFromClient(name);
	}
}
