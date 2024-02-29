package com.example.amazonagencytechtask.repository;

import com.example.amazonagencytechtask.model.db_collections.statistics.SalesAndTrafficByDate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SalesAndTrafficByDateRepository extends MongoRepository<SalesAndTrafficByDate, String> {
}
