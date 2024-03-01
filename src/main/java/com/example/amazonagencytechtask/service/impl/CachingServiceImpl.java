package com.example.amazonagencytechtask.service.impl;

import com.example.amazonagencytechtask.service.CachingService;
import com.example.amazonagencytechtask.service.ReportService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CachingServiceImpl implements CachingService {
    private final ReportService reportService;

    @Override
    public void updateCache() {
        reportService.findAllSalesAndTrafficByDate();
        reportService.findAllSalesAndTrafficByAsin();
        reportService.findSummaryStatisticsOfAllSalesAndTrafficByDate();
        reportService.findSummaryStatisticsOfAllSalesAndTrafficByAsin();
    }

    @Override
    public void updateDataByAsinsCache(List<String> asins) {
        reportService.findDataByAsins(asins);
    }

    @Override
    public void updateDataByDatesCache(List<String> dates) {
        reportService.findDataByDates(dates);
    }
}
