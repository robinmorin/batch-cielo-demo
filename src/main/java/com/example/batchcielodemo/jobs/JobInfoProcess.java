package com.example.batchcielodemo.jobs;

import com.example.batchcielodemo.entities.InfoProcess;
import com.example.batchcielodemo.listeners.*;
import com.example.batchcielodemo.models.InfoRecordFile;
import com.example.batchcielodemo.readers.ReaderInfoProcess;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class JobInfoProcess {

    @Value("#{systemProperties['PROCESS_FILE_PATH']}")
    private String filePath;

    @Value("#{systemProperties['PROCESS_FILE_HAS_HEADER']}")
    private Boolean hasHeader;

    @Bean
    public ItemReader<InfoRecordFile> reader(){
        return new ReaderInfoProcess(filePath,hasHeader);
    }

    @Bean(name = "mainJob")
    public Job job(JobRepository jobRepository, @Qualifier("mainStep") Step step) {
        return new JobBuilder("mainJob")
                .repository(jobRepository)
                .preventRestart()
                .listener(new JobExecListener())
                .start(step)
                .build();
    }

    @Bean(name = "mainStep")
    public Step step1(JobRepository jobRepository,
                      @Qualifier("jpaTrxMgmt") PlatformTransactionManager transactionManager,
                      ItemReader<InfoRecordFile> reader,
                      ItemProcessor<InfoRecordFile, InfoProcess> processor,
                      ItemWriter<InfoProcess> writer) {
        return new StepBuilder("mainStep").
                <InfoRecordFile,InfoProcess> chunk(2)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .repository(jobRepository)
                .transactionManager(transactionManager)
                .listener(new StepExecListener())
                .listener(new ReadExecListener())
                .listener(new ProcessExecListener())
                .listener(new WriteExecListener())
                .build();
    }


}
