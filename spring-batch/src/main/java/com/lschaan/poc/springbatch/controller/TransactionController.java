package com.lschaan.poc.springbatch.controller;

import com.lschaan.poc.springbatch.launcher.TransactionJobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@RequestMapping("/api/v1/start")
public class TransactionController {

  @Autowired private TransactionJobLauncher transactionJobLauncher;

  @GetMapping(value = "/ab")
  public ResponseEntity<?> getAB() {
    return transactionJobLauncher.launchTransactionJob();
  }

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.lschaan.poc.springbatch"))
        .build();
  }
}
