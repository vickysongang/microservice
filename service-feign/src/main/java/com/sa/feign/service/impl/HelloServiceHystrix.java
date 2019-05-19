package com.sa.feign.service.impl;

import org.springframework.stereotype.Component;

import com.sa.feign.service.HelloService;

@Component
public class HelloServiceHystrix implements HelloService {

	@Override
	public String sayHelloFromClient(String name) {
		return "Sorry " + name;
	}
}
