package com.mps.finances.data.config;

import com.mps.finances.account.BankAccountVo;
import com.mps.finances.account.CreditCardAccountVo;
import com.mps.finances.account.FinancialAccountVo;
import com.mps.finances.account.StocksToSellVo;
import com.mps.finances.data.repository.jpa.entities.account.BankAccount;
import com.mps.finances.data.repository.jpa.entities.account.CreditCardAccount;
import com.mps.finances.data.repository.jpa.entities.account.FinancialAccount;
import com.mps.finances.data.repository.jpa.entities.account.StocksToSell;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = "com.mps.finances.data.repository.jpa")
@EntityScan(basePackages = "com.mps.finances.data.repository.jpa.entities")
@ComponentScan(basePackages = "com.mps.finances")
@SpringBootApplication
@EnableEurekaClient
public class FinanceDataServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(FinanceDataServiceApplication.class, args);
	}



}
