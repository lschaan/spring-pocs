package com.lschaan.poc.batchmongo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document (collection =  "transaction")
@Getter
@Builder
public class TransactionDTO {
  @Id private String id;
  private String cpf, description;
}
