package com.lschaan.poc.springbatch.config;

import javax.sql.DataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories(
    entityManagerFactoryRef = "legadoEntityManagerFactory",
    basePackages = "com.lschaan.poc.springbatch.repository")
public class LegadoDataSourceConfig {
  private static final String DATASOURCE_URL = "jdbc:mysql://localhost:3306/legado";
  private static final String DATASOURCE_DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
  private static final String DATASOURCE_USERNAME = "";
  private static final String DATASOURCE_PASSWORD = "";

  @Bean(name = "legadoDataSource")
  public DataSource dataSource() {
    return DataSourceBuilder.create()
        .url(DATASOURCE_URL)
        .driverClassName(DATASOURCE_DRIVER_CLASS_NAME)
        .username(DATASOURCE_USERNAME)
        .password(DATASOURCE_PASSWORD)
        .build();
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
