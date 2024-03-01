package com.example.amazonagencytechtask.service;

import com.example.amazonagencytechtask.model.db_collections.statistics.SalesAndTrafficByAsin;
import com.example.amazonagencytechtask.model.db_collections.statistics.SalesAndTrafficByDate;
import com.example.amazonagencytechtask.model.db_collections.statistics.summaryStatistics.byAsin.SummaryStatisticsByAsin;
import com.example.amazonagencytechtask.model.db_collections.statistics.summaryStatistics.byDate.SummaryStatisticsByDate;
import java.util.List;

public interface ReportService {
    List<SalesAndTrafficByDate> findAllSalesAndTrafficByDate();

    List<SalesAndTrafficByAsin> findAllSalesAndTrafficByAsin();

    SummaryStatisticsByDate findSummaryStatisticsOfAllSalesAndTrafficByDate();
    SummaryStatisticsByAsin findSummaryStatisticsOfAllSalesAndTrafficByAsin();

    List<SalesAndTrafficByAsin> findDataByAsins(List<String> asins);

    List<SalesAndTrafficByDate> findDataByDates(List<String> dates);

    void updateReportFromFile();
}
