package com.example.batchcielodemo.readers;

import com.example.batchcielodemo.models.InfoRecordFile;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;


public class ReaderInfoProcess extends FlatFileItemReader<InfoRecordFile> {

    private final boolean hasHeader;
    private final String filePath;

    public ReaderInfoProcess(String filePath, boolean hasHeader) {
        this.filePath = filePath;
        this.hasHeader = hasHeader;
        initialize();
    }

    private void initialize() {
        var lineMapper = new DefaultLineMapper<InfoRecordFile>();
        lineMapper.setLineTokenizer(new DelimitedLineTokenizer(",") {
            {
                setNames("idRecord", "nameInfo", "addressInfo", "phoneInfo");
            }
        });
        lineMapper.setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {
            {
                setTargetType(InfoRecordFile.class);
            }
        });
        this.setResource(new ClassPathResource(filePath));
        this.setLinesToSkip(hasHeader ? 1 : 0);
        this.setLineMapper(lineMapper);

    }

    @Override
    public InfoRecordFile read() throws Exception {
        return super.read();
    }
}