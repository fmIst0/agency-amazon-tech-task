package com.example.amazonagencytechtask.service.impl;

import com.example.amazonagencytechtask.model.db_collections.Report;
import com.example.amazonagencytechtask.service.FileReaderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Component;

@Component
public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public Report readReportFromFile(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File(filePath), Report.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read reports from file", e);
        }
    }
}
