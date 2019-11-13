package com.lschaan.poc.batchmongo.batch.reader;

import com.lschaan.poc.batchmongo.dto.TransactionDTO;
import com.lschaan.poc.batchmongo.repository.TransactionRepository;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionReader extends RepositoryItemReader<TransactionDTO> {

  @Autowired private TransactionRepository repository;

  @PostConstruct
  public void init() {
    setRepository(repository);
    setSort(new HashMap<>());
    setMethodName("findAll");
  }
}
