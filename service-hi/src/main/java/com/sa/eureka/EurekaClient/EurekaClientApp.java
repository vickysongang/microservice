package com.sa.eureka.EurekaClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
@RestController
@RefreshScope
public class EurekaClientApp {
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApp.class, args);
	}

	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/hello")
	@HystrixCommand(fallbackMethod = "hiError")
	public String sayHi(@RequestParam(value = "name", defaultValue = "world") String name) {
		return "hello " + name + " from " + port;
	}

	public String hiError(String name) {
		return "Hi " + name + "hi error occurs.";
	}

	@RequestMapping("/info")
	@HystrixCommand(fallbackMethod = "infoError")
	public String info() {
		return "I am service-hi";
	}

	public String infoError() {
		return "info error occurs.";
	}
}
