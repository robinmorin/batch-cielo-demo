package com.example.batchcielodemo.listeners;

import com.example.batchcielodemo.models.InfoRecordFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemReadListener;

@Slf4j
public class ReadExecListener implements ItemReadListener<InfoRecordFile> {
    @Override
    public void beforeRead() {
        log.info("Starting read one record");
    }

    @Override
    public void afterRead(InfoRecordFile infoRecordFile) {
        log.info("Did read record #{}", infoRecordFile.getIdRecord());
    }

    @Override
    public void onReadError(Exception e) {
        log.error("Ocurrs exception reading record. Message: {}", e.getMessage());
    }
}
