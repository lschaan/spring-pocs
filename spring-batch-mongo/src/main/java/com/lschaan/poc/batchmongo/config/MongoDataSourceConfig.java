package com.lschaan.poc.batchmongo.config;

import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDataSourceConfig {

  @Bean("mongoTemplate")
  public MongoTemplate mongoTemplate(
      @Qualifier("mongoProperties") MongoProperties mongoProperties) {
    return new MongoTemplate(MongoClients.create(), mongoProperties.getDatabase());
  }

  @Bean("mongoProperties")
  @ConfigurationProperties("app.datasource.mongodb")
  public MongoProperties mongoProperties() {
    return new MongoProperties();
  }
}
