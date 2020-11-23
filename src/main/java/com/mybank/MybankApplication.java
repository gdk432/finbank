package com.mybank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MybankApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybankApplication.class, args);
	}

}
