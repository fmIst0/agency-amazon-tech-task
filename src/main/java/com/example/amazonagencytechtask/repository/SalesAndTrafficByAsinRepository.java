package com.example.amazonagencytechtask.repository;

import com.example.amazonagencytechtask.model.db_collections.statistics.SalesAndTrafficByAsin;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SalesAndTrafficByAsinRepository {
    private final MongoTemplate mongoTemplate;

    public List<SalesAndTrafficByAsin> findDataByAsins(List<String> asins) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("salesAndTrafficByAsin.parentAsin").in(asins)),
                Aggregation.unwind("salesAndTrafficByAsin"),
                Aggregation.match(Criteria.where("salesAndTrafficByAsin.parentAsin").in(asins)),
                Aggregation.replaceRoot("salesAndTrafficByAsin")
        );

        AggregationResults<SalesAndTrafficByAsin> results =
                mongoTemplate.aggregate(aggregation, "reports", SalesAndTrafficByAsin.class);

        return results.getMappedResults();
    }
}
