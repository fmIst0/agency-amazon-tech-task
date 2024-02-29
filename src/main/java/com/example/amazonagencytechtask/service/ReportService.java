package com.example.amazonagencytechtask.service;

import com.example.amazonagencytechtask.model.db_collections.statistics.SalesAndTrafficByAsin;
import com.example.amazonagencytechtask.model.db_collections.statistics.SalesAndTrafficByDate;
import com.example.amazonagencytechtask.model.db_collections.statistics.summaryStatistics.byAsin.SummaryStatisticsByAsin;
import com.example.amazonagencytechtask.model.db_collections.statistics.summaryStatistics.byDate.SummaryStatisticsByDate;
import java.util.List;

public interface ReportService {
    List<SalesAndTrafficByDate> findAllSalesAndTrafficByDate(String reportId);

    List<SalesAndTrafficByAsin> findAllSalesAndTrafficByAsin(String reportId);

    SummaryStatisticsByDate findSummaryStatisticsOfAllSalesAndTrafficByDate(String reportId);
    SummaryStatisticsByAsin findSummaryStatisticsOfAllSalesAndTrafficByAsin(String reportId);
}
