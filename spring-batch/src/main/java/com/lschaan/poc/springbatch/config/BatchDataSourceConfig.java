package com.lschaan.poc.springbatch.config;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BatchDataSourceConfig {
  private static final String DATASOURCE_URL = "jdbc:mysql://localhost:3306/batch";
  private static final String DATASOURCE_DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
  private static final String DATASOURCE_USERNAME = "";
  private static final String DATASOURCE_PASSWORD = "";

  @Bean(name = "batchDataSource")
  @Primary
  public DataSource dataSource() {
    return DataSourceBuilder.create()
        .url(DATASOURCE_URL)
        .driverClassName(DATASOURCE_DRIVER_CLASS_NAME)
        .username(DATASOURCE_USERNAME)
        .password(DATASOURCE_PASSWORD)
        .build();
  }
}
