package com.example.amazonagencytechtask.repository;

import com.example.amazonagencytechtask.model.db_collections.statistics.SalesAndTrafficByDate;
import java.util.List;
import java.util.TreeSet;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
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
        query.addCriteria(Criteria.where("date").is(date));
        return mongoTemplate.find(query, SalesAndTrafficByDate.class);
    }

    private List<SalesAndTrafficByDate> findByTwoDates(List<String> dates) {
        TreeSet<String> sortedDates = new TreeSet<>(dates);
        Query query = new Query();
        query.addCriteria(Criteria.where("date").gte(sortedDates.first()).lte(sortedDates.last()));
        return mongoTemplate.find(query, SalesAndTrafficByDate.class);
    }
}
