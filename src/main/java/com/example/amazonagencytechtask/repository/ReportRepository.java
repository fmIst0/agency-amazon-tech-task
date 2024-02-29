package com.example.amazonagencytechtask.repository;

import com.example.amazonagencytechtask.model.db_collections.Report;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository<Report, String> {
}
