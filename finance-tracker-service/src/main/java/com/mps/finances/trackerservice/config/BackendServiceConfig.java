package com.mps.finances.trackerservice.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
public class BackendServiceConfig {

  @Value("${person.data.service.url}")
  public String personDataServiceURL;

 // @Value("${stock.quote.service.url")
  public  String stockQuoteServiceUrl;




}
