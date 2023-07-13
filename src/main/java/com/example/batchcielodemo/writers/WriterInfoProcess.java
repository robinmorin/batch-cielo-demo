package com.example.batchcielodemo.writers;

import com.example.batchcielodemo.entities.InfoProcess;
import com.example.batchcielodemo.repositories.InfoProcessRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WriterInfoProcess implements ItemWriter<InfoProcess> {

    @Autowired
    private InfoProcessRepository processRepository;

    @Override
    public void write(List<? extends InfoProcess> list) {
        processRepository.saveAll(list);
    }
}
