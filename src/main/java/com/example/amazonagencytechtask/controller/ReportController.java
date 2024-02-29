package com.example.amazonagencytechtask.controller;

import com.example.amazonagencytechtask.model.db_collections.statistics.SalesAndTrafficByAsin;
import com.example.amazonagencytechtask.model.db_collections.statistics.SalesAndTrafficByDate;
import com.example.amazonagencytechtask.model.db_collections.statistics.summaryStatistics.byAsin.SummaryStatisticsByAsin;
import com.example.amazonagencytechtask.model.db_collections.statistics.summaryStatistics.byDate.SummaryStatisticsByDate;
import com.example.amazonagencytechtask.service.ReportService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/reports")
public class ReportController {
    private final ReportService reportService;

    @GetMapping("/{reportId}/by-date")
    public List<SalesAndTrafficByDate> getAllSalesAndTrafficByDate(@PathVariable String reportId) {
        return reportService.findAllSalesAndTrafficByDate(reportId);
    }

    @GetMapping("/{reportId}/by-asin")
    public List<SalesAndTrafficByAsin> getAllSalesAndTrafficByAsin(@PathVariable String reportId) {
        return reportService.findAllSalesAndTrafficByAsin(reportId);
    }

    @GetMapping("/{reportId}/summary-statistics-by-date")
    public SummaryStatisticsByDate getSummaryStatisticsOfAllSalesAndTrafficByDate(@PathVariable String reportId) {
        return reportService.findSummaryStatisticsOfAllSalesAndTrafficByDate(reportId);
    }

    @GetMapping("/{reportId}/summary-statistics-by-asin")
    public SummaryStatisticsByAsin getSummaryStatisticsOfAllSalesAndTrafficByAsin(@PathVariable String reportId) {
        return reportService.findSummaryStatisticsOfAllSalesAndTrafficByAsin(reportId);
    }
}
