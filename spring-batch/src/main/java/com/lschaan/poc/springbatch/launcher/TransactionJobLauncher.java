package com.lschaan.poc.springbatch.launcher;

import lombok.NoArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class TransactionJobLauncher {
  private Job job;
  private JobLauncher jobLauncher;

  @Autowired
  public TransactionJobLauncher(@Qualifier("transactionJob") Job job, JobLauncher jobLauncher) {
    this.job = job;
    this.jobLauncher = jobLauncher;
  }

  public HttpStatus launchTransactionJob() {
    System.out.println(job.getName() + " launched");
    try {
      jobLauncher.run(job, newExecution());
    } catch (Exception e) {
      e.printStackTrace();
      return HttpStatus.INTERNAL_SERVER_ERROR;
    }
    return HttpStatus.OK;
  }

  private JobParameters newExecution() {
    return new JobParameters();
  }
}
