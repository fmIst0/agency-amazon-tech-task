package com.example.amazonagencytechtask.model.db_collections.statistics;

import com.example.amazonagencytechtask.model.db_collections.statistics.salesData.SalesByAsin;
import com.example.amazonagencytechtask.model.db_collections.statistics.salesData.TrafficByAsin;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SalesAndTrafficByAsin {
    private String id;
    private String parentAsin;
    private SalesByAsin salesByAsin;
    private TrafficByAsin trafficByAsin;
}
