package com.example.amazonagencytechtask.repository;

import com.example.amazonagencytechtask.model.db_collections.Report;
import com.example.amazonagencytechtask.model.db_collections.statistics.SalesAndTrafficByDate;
import java.util.List;
import java.util.TreeSet;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SalesAndTrafficByDateRepository {
    private final MongoTemplate mongoTemplate;

    public List<SalesAndTrafficByDate> findDataByDates(List<String> dates) {
        if (dates.size() == 1) {
            return findByOneDate(dates);
        }
        if (dates.size() == 2) {
            return findByTwoDates(dates);
        }
        throw new RuntimeException("Try to find information by dates using one or a range of two dates!");
    }

    private List<SalesAndTrafficByDate> findByOneDate(List<String> dates) {
        String date = dates.get(0);
        Query query = new Query();
        query.addCriteria(
                Criteria.where("salesAndTrafficByDate")
                        .elemMatch(Criteria.where("date").is(date))
        );
        query.fields().include("salesAndTrafficByDate.$");
        return mongoTemplate.find(query, Report.class)
                .stream()
                .flatMap(report -> report.getSalesAndTrafficByDate().stream())
                .toList();
    }

    private List<SalesAndTrafficByDate> findByTwoDates(List<String> dates) {
        TreeSet<String> sortedDates = new TreeSet<>(dates);
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("salesAndTrafficByDate.date").gte(sortedDates.first()).lte(sortedDates.last())),
                Aggregation.unwind("salesAndTrafficByDate"),
                Aggregation.match(Criteria.where("salesAndTrafficByDate.date").gte(sortedDates.first()).lte(sortedDates.last())),
                Aggregation.replaceRoot("salesAndTrafficByDate")
        );

        AggregationResults<SalesAndTrafficByDate> results =
                mongoTemplate.aggregate(aggregation, "reports", SalesAndTrafficByDate.class);

        return results.getMappedResults();
    }
}
