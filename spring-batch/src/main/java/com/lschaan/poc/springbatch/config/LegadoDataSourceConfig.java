package com.lschaan.poc.springbatch.config;

import javax.sql.DataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories(
    entityManagerFactoryRef = "legadoEntityManagerFactory",
    basePackages = "com.lschaan.poc.springbatch.repository")
public class LegadoDataSourceConfig {

  @Bean(name = "legadoDataSource")
  public DataSource dataSource(
      @Qualifier("legadoDataSourceProperties") DataSourceProperties dataSourceProperties) {
    return dataSourceProperties.initializeDataSourceBuilder().build();
  }

  @Bean("legadoDataSourceProperties")
  @ConfigurationProperties("app.datasource.legado")
  public DataSourceProperties dataSourceProperties() {
    return new DataSourceProperties();
  }

  @Bean(name = "legadoEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(
      @Qualifier("legadoDataSource") DataSource dataSource) {
    return new LocalContainerEntityManagerFactoryBean() {
      {
        setDataSource(dataSource);
        setPackagesToScan("com.lschaan.poc.springbatch.dto");
        setPersistenceProvider(new HibernatePersistenceProvider());
      }
    };
  }
}
