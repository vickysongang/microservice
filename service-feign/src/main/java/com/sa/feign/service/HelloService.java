package com.sa.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sa.feign.service.impl.HelloServiceHystrix;

@FeignClient(value = "service-hi", fallback = HelloServiceHystrix.class)
public interface HelloService {
	@RequestMapping("/hello")
	public String sayHelloFromClient(@RequestParam(value = "name", defaultValue = "world") String name);
}
