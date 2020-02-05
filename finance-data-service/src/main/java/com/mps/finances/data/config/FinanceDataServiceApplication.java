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
import org.springframework.beans.factory.annotation.Qualifier;
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

	@Bean(name="voToEntityModelMapper")
	public ModelMapper getVoToEntityModelMapper() {
		ModelMapper modelMapper = new ModelMapper();

		modelMapper.createTypeMap(FinancialAccountVo.class, FinancialAccount.class)
				   .include(BankAccountVo.class, FinancialAccount.class)
				   .include(CreditCardAccountVo.class, FinancialAccount.class)
				   .include(StocksToSellVo.class, FinancialAccount.class);


		modelMapper.typeMap(BankAccountVo.class, FinancialAccount.class)
				   .setProvider(new Provider<FinancialAccount>() {
					   public FinancialAccount get(ProvisionRequest<FinancialAccount> request) {
						   return new BankAccount();
					   }
				   });
		modelMapper.typeMap(CreditCardAccountVo.class, FinancialAccount.class)
				   .setProvider(new Provider<FinancialAccount>() {
					   public FinancialAccount get(ProvisionRequest<FinancialAccount> request) {
						   return new CreditCardAccount();
					   }
				   });
		modelMapper.typeMap(StocksToSellVo.class, FinancialAccount.class)
				   .setProvider(new Provider<FinancialAccount>() {
					   public FinancialAccount get(ProvisionRequest<FinancialAccount> request) {
						   return new StocksToSell();
					   }
				   });


		return modelMapper;
	}


	@Bean(name="entitytoVoModelMapper")
	public ModelMapper getEntitytoVoModelMapper() {
		ModelMapper modelMapper = new ModelMapper();

		modelMapper.createTypeMap(FinancialAccount.class, FinancialAccountVo.class)
				   .include(BankAccount.class, FinancialAccountVo.class)
				   .include(CreditCardAccount.class, FinancialAccountVo.class)
				   .include(StocksToSell.class, FinancialAccountVo.class);


		modelMapper.typeMap(BankAccount.class, FinancialAccountVo.class)
				   .setProvider(new Provider<FinancialAccountVo>() {
					   public FinancialAccountVo get(ProvisionRequest<FinancialAccountVo> request) {
						   return new BankAccountVo();
					   }
				   });
		modelMapper.typeMap(CreditCardAccount.class, FinancialAccountVo.class)
				   .setProvider(new Provider<FinancialAccountVo>() {
					   public FinancialAccountVo get(ProvisionRequest<FinancialAccountVo> request) {
						   return new CreditCardAccountVo();
					   }
				   });
		modelMapper.typeMap(StocksToSell.class, FinancialAccountVo.class)
				   .setProvider(new Provider<FinancialAccountVo>() {
					   public FinancialAccountVo get(ProvisionRequest<FinancialAccountVo> request) {
						   return new StocksToSellVo();
					   }
				   });


		return modelMapper;
	}
}
