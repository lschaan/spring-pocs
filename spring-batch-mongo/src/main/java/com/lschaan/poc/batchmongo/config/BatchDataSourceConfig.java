package com.lschaan.poc.batchmongo.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BatchDataSourceConfig {
  @Bean(name = "batchDataSource")
  @Primary
  public DataSource dataSource(
      @Qualifier("batchDataSourceProperties") DataSourceProperties dataSourceProperties) {
    return dataSourceProperties.initializeDataSourceBuilder().build();
  }

  @Bean(name = "batchDataSourceProperties")
  @ConfigurationProperties("app.datasource.batch")
  @Primary
  public DataSourceProperties dataSourceProperties() {
    return new DataSourceProperties();
  }
}
