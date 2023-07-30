package com.example.batchcielodemo.listeners;

import com.example.batchcielodemo.entities.InfoProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemWriteListener;

import java.util.List;

@Slf4j
public class WriteExecListener implements ItemWriteListener<InfoProcess> {
    @Override
    public void beforeWrite(List<? extends InfoProcess> list) {
      log.info("Have {} records ready to write", list.size());
        list.forEach(System.out::println);
    }

    @Override
    public void afterWrite(List<? extends InfoProcess> list) {
        log.info("Its already writed {} records", list.size());
        list.forEach(System.out::println);
    }

    @Override
    public void onWriteError(Exception e, List<? extends InfoProcess> list) {
        log.error("Ocurrs exception when writing records. Message: {}", e.getMessage());
    }
}
