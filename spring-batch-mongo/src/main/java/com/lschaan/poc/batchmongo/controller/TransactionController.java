package com.lschaan.poc.batchmongo.controller;

import com.lschaan.poc.batchmongo.launcher.TransactionJobLauncher;
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
@RequestMapping("/api/v1/start")
@EnableSwagger2
public class TransactionController {

  @Autowired TransactionJobLauncher transactionJobLauncher;

  @GetMapping(value = "/generateFile")
  public ResponseEntity<?> generateFile() {
    try {
      transactionJobLauncher.launchTransactionJob();
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.lschaan.poc.batchmongo"))
        .build();
  }
}
