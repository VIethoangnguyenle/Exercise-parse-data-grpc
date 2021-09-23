package com.example.ReadData.service;

import com.example.ReadData.parser.StockInfoParser;
import com.example.ReadData.reader.BaseFileReader;
import com.example.ReadData.reader.DataFileReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReadDataServiceImpl implements ReadDataService{
    @Value("${reader.root.path}")
    private String path;

    @Value("${reader.data.file}")
    private String file;

    @Value("${reader.file}")
    private String filePath;

    @Bean
    public void init() {
        initParsers();
        DataFileReader.create(filePath);
    }

    private void initParsers() {
        StockInfoParser.create();
    }

}
