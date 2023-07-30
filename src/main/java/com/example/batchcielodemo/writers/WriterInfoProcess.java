package com.example.batchcielodemo.writers;

import com.example.batchcielodemo.entities.InfoProcess;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;

@Component
public class WriterInfoProcess extends JpaItemWriter<InfoProcess> {
    public WriterInfoProcess(EntityManagerFactory entityManagerFactory) {
        this.setEntityManagerFactory(entityManagerFactory);
    }
}
