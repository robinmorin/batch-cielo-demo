package com.example.batchcielodemo.jobs;

import com.example.batchcielodemo.entities.InfoProcess;
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

    @Value("#{systemProperties['process.file.path']}")
    private String filePath;

    @Value("#{systemProperties['process.file.has.header']}")
    private Boolean hasHeader;

    @Bean
    public ItemReader<InfoRecordFile> reader(){
        return new ReaderInfoProcess(filePath,hasHeader);
    }

//    @Bean
//    public ItemProcessor<InfoRecordFile, InfoProcess> processor(){
//        return null;
//    }

    @Bean(name = "mainJob")
    public Job job(JobRepository jobRepository, @Qualifier("mainStep") Step step) {
        return new JobBuilder("mainJob")
                .repository(jobRepository)
                .preventRestart()
                .start(step)
                .build();
    }


    @Bean(name = "mainStep")
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager, ItemReader<InfoRecordFile> reader,
                         ItemProcessor<InfoRecordFile, InfoProcess> processor, ItemWriter<InfoProcess> writer) {
        return new StepBuilder("mainStep").
                <InfoRecordFile,InfoProcess> chunk(2)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .repository(jobRepository)
                .transactionManager(transactionManager).build();
    }


}