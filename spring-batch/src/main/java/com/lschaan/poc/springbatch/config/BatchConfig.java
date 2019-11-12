package com.lschaan.poc.springbatch.config;

import javax.sql.DataSource;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {

  @Bean
  public BatchConfigurer configurer(@Qualifier("batchDataSource") DataSource dataSource) {
    return new DefaultBatchConfigurer(dataSource);
  }
}
