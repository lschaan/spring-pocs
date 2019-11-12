package com.lschaan.poc.springbatch.batch.writer;

import com.lschaan.poc.springbatch.dto.TransactionDTO;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.FieldExtractor;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class TransactionWriter {

  @Bean
  public ItemWriter<TransactionDTO> transactionDTOItemWriter() {
    FlatFileItemWriter<TransactionDTO> csvFileWriter = new FlatFileItemWriter<>();

    String exportHeader = "ID;CPF;DESCRIPTION";
    StringHeaderWriter headerWriter = new StringHeaderWriter(exportHeader);
    csvFileWriter.setHeaderCallback(headerWriter);

    LineAggregator<TransactionDTO> lineAggregator = createLineAggregator();
    csvFileWriter.setLineAggregator(lineAggregator);
    csvFileWriter.setResource(
        new FileSystemResource("transaction.csv"));

    return csvFileWriter;
  }

  private LineAggregator<TransactionDTO> createLineAggregator() {
    DelimitedLineAggregator<TransactionDTO> lineAggregator = new DelimitedLineAggregator<>();
    lineAggregator.setDelimiter(";");

    FieldExtractor<TransactionDTO> extractor = createExtractor();
    lineAggregator.setFieldExtractor(extractor);

    return lineAggregator;
  }

  private FieldExtractor<TransactionDTO> createExtractor() {
    BeanWrapperFieldExtractor<TransactionDTO> extractor = new BeanWrapperFieldExtractor<>();
    extractor.setNames(new String[] {"id_transaction", "cpf", "description"});
    return extractor;
  }
}
