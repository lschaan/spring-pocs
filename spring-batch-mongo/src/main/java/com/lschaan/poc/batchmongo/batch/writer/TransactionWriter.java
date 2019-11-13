package com.lschaan.poc.batchmongo.batch.writer;

import com.lschaan.poc.batchmongo.dto.TransactionDTO;
import javax.annotation.PostConstruct;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.FieldExtractor;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class TransactionWriter extends FlatFileItemWriter<TransactionDTO> {

  @PostConstruct
  public void init() {
    setHeaderCallback(new StringHeaderWriter("ID;CPF;DESCRIPTION"));
    setResource(new FileSystemResource("transaction.csv"));
    setLineAggregator(createLineAggregator());
  }

  private LineAggregator<TransactionDTO> createLineAggregator() {
    DelimitedLineAggregator<TransactionDTO> lineAggregator = new DelimitedLineAggregator<>();
    lineAggregator.setDelimiter(";");
    lineAggregator.setFieldExtractor(createExtractor());
    return lineAggregator;
  }

  private FieldExtractor<TransactionDTO> createExtractor() {
    BeanWrapperFieldExtractor<TransactionDTO> extractor = new BeanWrapperFieldExtractor<>();
    extractor.setNames(new String[] {"id", "cpf", "description"});
    return extractor;
  }
}
