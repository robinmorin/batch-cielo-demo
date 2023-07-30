package com.example.batchcielodemo.listeners;

import com.example.batchcielodemo.entities.InfoProcess;
import com.example.batchcielodemo.models.InfoRecordFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemProcessListener;

@Slf4j
public class ProcessExecListener implements ItemProcessListener<InfoRecordFile,InfoProcess> {
    @Override
    public void beforeProcess(InfoRecordFile infoRecordFile) {
        log.info("Reading NameInfo {}", infoRecordFile.getNameInfo());
    }

    @Override
    public void afterProcess(InfoRecordFile infoRecordFile, InfoProcess infoProcess) {
        log.info("Converting in Name {}", infoProcess.getName());
    }

    @Override
    public void onProcessError(InfoRecordFile infoRecordFile, Exception e) {
        log.error("Error processing record {} - Message: {}", infoRecordFile.getIdRecord(),e.getMessage());
    }
}
