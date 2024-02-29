package com.example.amazonagencytechtask.service.impl;

import com.example.amazonagencytechtask.exception.DataBaseNotFoundException;
import com.example.amazonagencytechtask.model.db_collections.Report;
import com.example.amazonagencytechtask.model.db_collections.statistics.SalesAndTrafficByAsin;
import com.example.amazonagencytechtask.model.db_collections.statistics.SalesAndTrafficByDate;
import com.example.amazonagencytechtask.model.db_collections.statistics.summaryStatistics.byAsin.SummaryStatisticsByAsin;
import com.example.amazonagencytechtask.model.db_collections.statistics.summaryStatistics.byDate.SummaryStatisticsByDate;
import com.example.amazonagencytechtask.repository.ReportRepository;
import com.example.amazonagencytechtask.service.ReportService;
import com.example.amazonagencytechtask.service.SummaryStatisticsCalcHelper;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;
    private final SummaryStatisticsCalcHelper summaryStatisticsCalcHelper;

    @Override
    public List<SalesAndTrafficByDate> findAllSalesAndTrafficByDate(String reportId) {

        checkIfReportPresent(reportId);

        return reportRepository.findById(reportId)
                .stream()
                .flatMap(report -> report.getSalesAndTrafficByDate().stream())
                .toList();
    }

    @Override
    public List<SalesAndTrafficByAsin> findAllSalesAndTrafficByAsin(String reportId) {

        checkIfReportPresent(reportId);

        return reportRepository.findById(reportId)
                .stream()
                .flatMap(report -> report.getSalesAndTrafficByAsin().stream())
                .toList();
    }

    @Override
    public SummaryStatisticsByDate findSummaryStatisticsOfAllSalesAndTrafficByDate(String reportId) {
        SummaryStatisticsByDate summaryStatisticsByDate = new SummaryStatisticsByDate(summaryStatisticsCalcHelper);
        summaryStatisticsByDate.calculateSummaryStatisticsByDate(findAllSalesAndTrafficByDate(reportId));
        return summaryStatisticsByDate;
    }

    @Override
    public SummaryStatisticsByAsin findSummaryStatisticsOfAllSalesAndTrafficByAsin(String reportId) {
        SummaryStatisticsByAsin summaryStatisticsByAsin = new SummaryStatisticsByAsin(summaryStatisticsCalcHelper);
        summaryStatisticsByAsin.calculateSummaryStatisticsByAsin(findAllSalesAndTrafficByAsin(reportId));
        return summaryStatisticsByAsin;
    }

    private void checkIfReportPresent(String reportId) {
        Optional<Report> optionalReport = reportRepository.findById(reportId);
        if (optionalReport.isEmpty()) {
            throw new DataBaseNotFoundException("There is no report in DB with id: " + reportId);
        }
    }
}
