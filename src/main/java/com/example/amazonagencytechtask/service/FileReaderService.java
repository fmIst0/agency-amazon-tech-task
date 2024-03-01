package com.example.amazonagencytechtask.service;

import com.example.amazonagencytechtask.model.db_collections.Report;

public interface FileReaderService {
    Report readReportFromFile(String filePath);
}
