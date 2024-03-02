package com.example.amazonagencytechtask.service.impl;

import com.example.amazonagencytechtask.model.db_collections.statistics.SalesAndTrafficByAsin;
import com.example.amazonagencytechtask.model.db_collections.statistics.SalesAndTrafficByDate;
import com.example.amazonagencytechtask.model.db_collections.statistics.summaryStatistics.byAsin.SummaryStatisticsByAsin;
import com.example.amazonagencytechtask.model.db_collections.statistics.summaryStatistics.byDate.SummaryStatisticsByDate;
import com.example.amazonagencytechtask.repository.ReportRepository;
import com.example.amazonagencytechtask.repository.SalesAndTrafficByAsinRepository;
import com.example.amazonagencytechtask.repository.SalesAndTrafficByDateRepository;
import com.example.amazonagencytechtask.service.ReportService;
import com.example.amazonagencytechtask.service.SummaryStatisticsCalcHelper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;
    private final SummaryStatisticsCalcHelper summaryStatisticsCalcHelper;
    private final SalesAndTrafficByAsinRepository salesAndTrafficByAsinRepository;
    private final SalesAndTrafficByDateRepository salesAndTrafficByDateRepository;

    @Override
    @CachePut(value = "salesAndTrafficByDateCache", key = "#root.methodName")
    public List<SalesAndTrafficByDate> findAllSalesAndTrafficByDate() {
        return reportRepository.findAll()
                .stream()
                .flatMap(report -> report.getSalesAndTrafficByDate().stream())
                .toList();
    }

    @Override
    @CachePut(value = "salesAndTrafficByAsinCache", key = "#root.methodName")
    public List<SalesAndTrafficByAsin> findAllSalesAndTrafficByAsin() {
        return reportRepository.findAll()
                .stream()
                .flatMap(report -> report.getSalesAndTrafficByAsin().stream())
                .toList();
    }

    @Override
    @CachePut(value = "summaryStatisticsOfAllSalesAndTrafficByDateCache", key = "#root.methodName")
    public SummaryStatisticsByDate findSummaryStatisticsOfAllSalesAndTrafficByDate() {
        SummaryStatisticsByDate summaryStatisticsByDate = new SummaryStatisticsByDate(summaryStatisticsCalcHelper);
        summaryStatisticsByDate.calculateSummaryStatisticsByDate(findAllSalesAndTrafficByDate());
        return summaryStatisticsByDate;
    }

    @Override
    @CachePut(value = "summaryStatisticsOfAllSalesAndTrafficByAsinCache", key = "#root.methodName")
    public SummaryStatisticsByAsin findSummaryStatisticsOfAllSalesAndTrafficByAsin() {
        SummaryStatisticsByAsin summaryStatisticsByAsin = new SummaryStatisticsByAsin(summaryStatisticsCalcHelper);
        summaryStatisticsByAsin.calculateSummaryStatisticsByAsin(findAllSalesAndTrafficByAsin());
        return summaryStatisticsByAsin;
    }

    @Override
    public List<SalesAndTrafficByAsin> findDataByAsins(List<String> asins) {
        return salesAndTrafficByAsinRepository.findDataByAsins(asins);
    }

    @Override
    public List<SalesAndTrafficByDate> findDataByDates(List<String> dates) {
        return salesAndTrafficByDateRepository.findDataByDates(dates);
    }
}
