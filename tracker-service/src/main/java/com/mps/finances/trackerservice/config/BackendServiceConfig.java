package com.mps.finances.trackerservice.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "backend.service")
public class BackendServiceConfig {

  public  String personUrl;
  public  String stockUrl;




}
