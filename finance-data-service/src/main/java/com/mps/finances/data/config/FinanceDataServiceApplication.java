package com.mps.finances.data.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = "com.mps.finances.data.repository.jpa")
@EntityScan(basePackages = "com.mps.finances.data.repository.jpa.entities")
@ComponentScan(basePackages = "com.mps.finances.data")
@SpringBootApplication
@EnableEurekaClient
public class FinanceDataServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(FinanceDataServiceApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
