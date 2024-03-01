package com.example.amazonagencytechtask.service.impl;

import com.example.amazonagencytechtask.model.db_collections.Report;
import com.example.amazonagencytechtask.model.db_collections.statistics.SalesAndTrafficByAsin;
import com.example.amazonagencytechtask.model.db_collections.statistics.SalesAndTrafficByDate;
import com.example.amazonagencytechtask.model.db_collections.statistics.summaryStatistics.byAsin.SummaryStatisticsByAsin;
import com.example.amazonagencytechtask.model.db_collections.statistics.summaryStatistics.byDate.SummaryStatisticsByDate;
import com.example.amazonagencytechtask.repository.ReportRepository;
import com.example.amazonagencytechtask.repository.SalesAndTrafficByAsinRepository;
import com.example.amazonagencytechtask.repository.SalesAndTrafficByDateRepository;
import com.example.amazonagencytechtask.service.FileReaderService;
import com.example.amazonagencytechtask.service.ReportService;
import com.example.amazonagencytechtask.service.SummaryStatisticsCalcHelper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;
    private final FileReaderService fileReaderService;
    private final SummaryStatisticsCalcHelper summaryStatisticsCalcHelper;
    private final SalesAndTrafficByAsinRepository salesAndTrafficByAsinRepository;
    private final SalesAndTrafficByDateRepository salesAndTrafficByDateRepository;

    @Override
    public List<SalesAndTrafficByDate> findAllSalesAndTrafficByDate() {
        return reportRepository.findAll()
                .stream()
                .flatMap(report -> report.getSalesAndTrafficByDate().stream())
                .toList();
    }

    @Override
    public List<SalesAndTrafficByAsin> findAllSalesAndTrafficByAsin() {
        return reportRepository.findAll()
                .stream()
                .flatMap(report -> report.getSalesAndTrafficByAsin().stream())
                .toList();
    }

    @Override
    public SummaryStatisticsByDate findSummaryStatisticsOfAllSalesAndTrafficByDate() {
        SummaryStatisticsByDate summaryStatisticsByDate = new SummaryStatisticsByDate(summaryStatisticsCalcHelper);
        summaryStatisticsByDate.calculateSummaryStatisticsByDate(findAllSalesAndTrafficByDate());
        return summaryStatisticsByDate;
    }

    @Override
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

    @Override
    @Scheduled(fixedRate = 10000)
    public void updateReportFromFile() {
        reportRepository.deleteAll();
        Report report = fileReaderService.readReportFromFile("src/main/resources/test_report.json");
        reportRepository.save(report);
    }
}
