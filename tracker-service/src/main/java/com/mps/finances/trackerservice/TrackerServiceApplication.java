package com.mps.finances.trackerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TrackerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackerServiceApplication.class, args);
	}

}
