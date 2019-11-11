package com.lschaan.poc.springbatch.config;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

  public static final String DATASOURCE_URL = "jdbc:mysql://localhost:3306/batch";
  public static final String DATASOURCE_DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
  public static final String DATASOURCE_USERNAME = "";
  public static final String DATASOURCE_PASSWORD = "";

  @Bean
  public DataSource dataSource() {
    return DataSourceBuilder.create()
        .url(DATASOURCE_URL)
        .driverClassName(DATASOURCE_DRIVER_CLASS_NAME)
        .username(DATASOURCE_USERNAME)
        .password(DATASOURCE_PASSWORD)
        .build();
  }
}
