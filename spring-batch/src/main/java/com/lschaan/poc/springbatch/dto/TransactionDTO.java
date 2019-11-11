package com.lschaan.poc.springbatch.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@Entity
@Table(name = "Transaction")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransactionDTO {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id_transaction;

  private String description;
  private String cpf;
}
