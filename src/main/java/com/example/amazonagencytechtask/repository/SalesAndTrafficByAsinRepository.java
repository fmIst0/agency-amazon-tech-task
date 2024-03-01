package com.example.amazonagencytechtask.repository;

import com.example.amazonagencytechtask.model.db_collections.statistics.SalesAndTrafficByAsin;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SalesAndTrafficByAsinRepository {
    private final MongoTemplate mongoTemplate;

    public List<SalesAndTrafficByAsin> findDataByAsins(List<String> asins) {
        Query query = new Query();
        query.addCriteria(Criteria.where("parentAsin").in(asins.toArray()));
        return mongoTemplate.find(query, SalesAndTrafficByAsin.class);
    }
}
