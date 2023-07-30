package com.example.batchcielodemo.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

@Slf4j
public class StepExecListener implements StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("Starting Step {} - Date Start: {}", stepExecution.getStepName(),stepExecution.getStartTime());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        log.info("Finishing Step {} - Status {} - Total Records Readed: {} - Total Records Writed: {}", stepExecution.getStepName(), stepExecution.getExitStatus().getExitCode(), stepExecution.getReadCount(), stepExecution.getWriteCount());
        return ExitStatus.COMPLETED;
    }
}
