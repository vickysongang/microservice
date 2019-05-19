package com.sa.ribbon.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {
	Logger logger = LoggerFactory.getLogger(HelloService.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@HystrixCommand(fallbackMethod = "sayHelloError")
	public String sayHello(String name) {
		return restTemplate.getForObject("http://service-hi/hello?name=" + name, String.class);
	}

	@HystrixCommand(fallbackMethod = "infoError")
	public String info() {
		return restTemplate.getForObject("http://service-hi/info", String.class);
	}

	public void logInstance() {
		ServiceInstance instance = loadBalancerClient.choose("SERVICE-HI");
		logger.info("instance info:" + instance.getHost() + " " + instance.getPort());
		Map<String, String> metadatas = instance.getMetadata();
		for (String key : metadatas.keySet()) {
			System.out.println("key is:" + key + " value is:" + metadatas.get(key));
		}
	}

	public String sayHelloError(String name) {
		return "Sorry " + name + " there is a error.";
	}

	public String infoError() {
		return "get info error";
	}
}
