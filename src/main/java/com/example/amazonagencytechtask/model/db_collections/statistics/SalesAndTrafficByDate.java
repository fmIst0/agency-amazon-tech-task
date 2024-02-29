package com.example.amazonagencytechtask.model.db_collections.statistics;

import com.example.amazonagencytechtask.model.db_collections.statistics.salesData.SalesByDate;
import com.example.amazonagencytechtask.model.db_collections.statistics.salesData.TrafficByDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesAndTrafficByDate {
    private String id;
    private String date;
    private SalesByDate salesByDate;
    private TrafficByDate trafficByDate;
}
