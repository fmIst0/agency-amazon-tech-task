package com.example.amazonagencytechtask.service;

import com.example.amazonagencytechtask.model.db_collections.statistics.salesData.SalesData;

public interface SummaryStatisticsCalcHelper {
    Integer getSafeValue(Integer value);

    Double getSafeValue(Double value);

    SalesData addSalesData(SalesData data1, SalesData data2);
}
