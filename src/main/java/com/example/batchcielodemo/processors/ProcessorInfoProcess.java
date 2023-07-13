package com.example.batchcielodemo.processors;

import com.example.batchcielodemo.entities.InfoProcess;
import com.example.batchcielodemo.models.InfoRecordFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class ProcessorInfoProcess implements ItemProcessor<InfoRecordFile, InfoProcess> {

    @Override
    public InfoProcess process(InfoRecordFile infoRecordFile) {
        return new ObjectMapper().convertValue(infoRecordFile, InfoProcess.class);
    }
}
