package com.example.amazonagencytechtask.controller;

import com.example.amazonagencytechtask.model.db_collections.statistics.SalesAndTrafficByAsin;
import com.example.amazonagencytechtask.model.db_collections.statistics.SalesAndTrafficByDate;
import com.example.amazonagencytechtask.model.db_collections.statistics.summaryStatistics.byAsin.SummaryStatisticsByAsin;
import com.example.amazonagencytechtask.model.db_collections.statistics.summaryStatistics.byDate.SummaryStatisticsByDate;
import com.example.amazonagencytechtask.service.ReportService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/reports")
public class ReportController {
    private final ReportService reportService;

    @GetMapping("/by-date")
    public List<SalesAndTrafficByDate> getAllSalesAndTrafficByDate() {
        return reportService.findAllSalesAndTrafficByDate();
    }

    @GetMapping("/by-asin")
    public List<SalesAndTrafficByAsin> getAllSalesAndTrafficByAsin() {
        return reportService.findAllSalesAndTrafficByAsin();
    }

    @GetMapping("/summary-statistics-by-date")
    public SummaryStatisticsByDate getSummaryStatisticsOfAllSalesAndTrafficByDate() {
        return reportService.findSummaryStatisticsOfAllSalesAndTrafficByDate();
    }

    @GetMapping("/summary-statistics-by-asin")
    public SummaryStatisticsByAsin getSummaryStatisticsOfAllSalesAndTrafficByAsin() {
        return reportService.findSummaryStatisticsOfAllSalesAndTrafficByAsin();
    }

    @GetMapping("/search-by-asins")
    public List<SalesAndTrafficByAsin> getDataByAsins(@RequestParam("parentAsins") List<String> asins) {
        return reportService.findDataByAsins(asins);
    }

    @GetMapping("/search-by-date")
    public List<SalesAndTrafficByDate> getDataByDates(@RequestParam("date") List<String> dates) {
        return reportService.findDataByDates(dates);
    }
}
