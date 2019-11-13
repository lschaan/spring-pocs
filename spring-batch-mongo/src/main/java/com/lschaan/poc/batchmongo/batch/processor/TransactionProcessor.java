package com.lschaan.poc.batchmongo.batch.processor;

import com.lschaan.poc.batchmongo.dto.TransactionDTO;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class TransactionProcessor implements ItemProcessor<TransactionDTO, TransactionDTO> {

  @Override
  public TransactionDTO process(TransactionDTO item) {
    return (item.getDescription().startsWith("a") ? item : null);
  }
}
