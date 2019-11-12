package com.lschaan.poc.springbatch.batch.writer;

import java.io.IOException;
import java.io.Writer;
import lombok.AllArgsConstructor;
import org.springframework.batch.item.file.FlatFileHeaderCallback;

@AllArgsConstructor
public class StringHeaderWriter implements FlatFileHeaderCallback {

  private final String header;

  @Override
  public void writeHeader(Writer writer) throws IOException {
    writer.write(header);
  }
}
