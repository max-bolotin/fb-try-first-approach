package com.example.mercury.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

  @Configuration
  public class AppConfig {
    @Bean
    public ObjectMapper getObjectMapper() {
      ObjectMapper objectMapper = new ObjectMapper();
      return objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
