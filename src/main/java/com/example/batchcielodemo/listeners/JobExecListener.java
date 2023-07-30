package com.example.batchcielodemo.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

@Slf4j
public class JobExecListener implements JobExecutionListener {
    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("Start processing file {}", System.getProperty("process.file.path") );
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("Finish processing file {}",  System.getProperty("process.file.path") );
    }
}
