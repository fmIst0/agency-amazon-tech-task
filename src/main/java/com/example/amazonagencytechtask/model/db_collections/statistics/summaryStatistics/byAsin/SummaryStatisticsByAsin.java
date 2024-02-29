package com.example.amazonagencytechtask.model.db_collections.statistics.summaryStatistics.byAsin;

import com.example.amazonagencytechtask.model.db_collections.statistics.SalesAndTrafficByAsin;
import com.example.amazonagencytechtask.model.db_collections.statistics.salesData.SalesByAsin;
import com.example.amazonagencytechtask.model.db_collections.statistics.salesData.TrafficByAsin;
import com.example.amazonagencytechtask.service.SummaryStatisticsCalcHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SummaryStatisticsByAsin {
    private TotalSalesByAsin totalSalesByAsin;
    private TotalTrafficByAsin totalTrafficByAsin;
    @JsonIgnore
    private SummaryStatisticsCalcHelper summaryStatisticsCalcHelper;

    public SummaryStatisticsByAsin(SummaryStatisticsCalcHelper summaryStatisticsCalcHelper) {
        this.summaryStatisticsCalcHelper = summaryStatisticsCalcHelper;
    }

    public void calculateSummaryStatisticsByAsin(List<SalesAndTrafficByAsin> salesAndTrafficByAsins) {
        totalSalesByAsin = new TotalSalesByAsin();
        totalTrafficByAsin = new TotalTrafficByAsin();

        for (SalesAndTrafficByAsin data : salesAndTrafficByAsins) {
            SalesByAsin salesByAsin = data.getSalesByAsin();
            TrafficByAsin trafficByAsin = data.getTrafficByAsin();

            this.totalSalesByAsin.setTotalUnitsOrdered(summaryStatisticsCalcHelper.getSafeValue(totalSalesByAsin.getTotalUnitsOrdered()) + salesByAsin.getUnitsOrdered());
            this.totalSalesByAsin.setTotalUnitsOrderedB2B(summaryStatisticsCalcHelper.getSafeValue(totalSalesByAsin.getTotalUnitsOrderedB2B()) + salesByAsin.getUnitsOrderedB2B());
            this.totalSalesByAsin.setTotalOrderedProductSales(summaryStatisticsCalcHelper.addSalesData(totalSalesByAsin.getTotalOrderedProductSales(), salesByAsin.getOrderedProductSales()));
            this.totalSalesByAsin.setTotalOrderedProductSalesB2B(summaryStatisticsCalcHelper.addSalesData(totalSalesByAsin.getTotalOrderedProductSalesB2B(), salesByAsin.getOrderedProductSalesB2B()));
            this.totalSalesByAsin.setAllTotalOrderItems(summaryStatisticsCalcHelper.getSafeValue(totalSalesByAsin.getAllTotalOrderItems()) + salesByAsin.getTotalOrderItems());
            this.totalSalesByAsin.setAllTotalOrderItemsB2B(summaryStatisticsCalcHelper.getSafeValue(totalSalesByAsin.getAllTotalOrderItemsB2B()) + salesByAsin.getTotalOrderItemsB2B());

            this.totalTrafficByAsin.setBrowserSessions(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getBrowserSessions()) + trafficByAsin.getBrowserSessions());
            this.totalTrafficByAsin.setBrowserSessionsB2B(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getBrowserSessionsB2B()) + trafficByAsin.getBrowserSessionsB2B());
            this.totalTrafficByAsin.setMobileAppSessions(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getMobileAppSessions()) + trafficByAsin.getMobileAppSessions());
            this.totalTrafficByAsin.setMobileAppSessionsB2B(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getMobileAppSessionsB2B()) + trafficByAsin.getMobileAppSessionsB2B());
            this.totalTrafficByAsin.setSessions(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getSessions()) + trafficByAsin.getSessions());
            this.totalTrafficByAsin.setSessionsB2B(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getSessionsB2B()) + trafficByAsin.getSessionsB2B());
            this.totalTrafficByAsin.setBrowserSessionPercentage(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getBrowserSessionPercentage()) + trafficByAsin.getBrowserSessionPercentage());
            this.totalTrafficByAsin.setBrowserSessionPercentageB2B(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getBrowserSessionPercentageB2B()) + trafficByAsin.getBrowserSessionPercentageB2B());
            this.totalTrafficByAsin.setMobileAppSessionPercentage(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getMobileAppSessionPercentage()) + trafficByAsin.getMobileAppSessionPercentage());
            this.totalTrafficByAsin.setMobileAppSessionPercentageB2B(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getMobileAppSessionPercentageB2B()) + trafficByAsin.getMobileAppSessionPercentageB2B());
            this.totalTrafficByAsin.setSessionPercentage(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getSessionPercentage()) + trafficByAsin.getSessionPercentage());
            this.totalTrafficByAsin.setSessionPercentageB2B(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getSessionPercentageB2B()) + trafficByAsin.getSessionPercentageB2B());
            this.totalTrafficByAsin.setBrowserPageViews(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getBrowserPageViews()) + trafficByAsin.getBrowserPageViews());
            this.totalTrafficByAsin.setBrowserPageViewsB2B(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getBrowserPageViewsB2B()) + trafficByAsin.getBrowserPageViewsB2B());
            this.totalTrafficByAsin.setMobileAppPageViews(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getMobileAppPageViews()) + trafficByAsin.getMobileAppPageViews());
            this.totalTrafficByAsin.setMobileAppPageViewsB2B(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getMobileAppPageViewsB2B()) + trafficByAsin.getMobileAppPageViewsB2B());
            this.totalTrafficByAsin.setPageViews(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getPageViews()) + trafficByAsin.getPageViews());
            this.totalTrafficByAsin.setPageViewsB2B(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getPageViewsB2B()) + trafficByAsin.getPageViewsB2B());
            this.totalTrafficByAsin.setBrowserPageViewsPercentage(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getBrowserPageViewsPercentage()) + trafficByAsin.getBrowserPageViewsPercentage());
            this.totalTrafficByAsin.setBrowserPageViewsPercentageB2B(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getBrowserPageViewsPercentageB2B()) + trafficByAsin.getBrowserPageViewsPercentageB2B());
            this.totalTrafficByAsin.setMobileAppPageViewsPercentage(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getMobileAppPageViewsPercentage()) + trafficByAsin.getMobileAppPageViewsPercentage());
            this.totalTrafficByAsin.setMobileAppPageViewsPercentageB2B(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getMobileAppPageViewsPercentageB2B()) + trafficByAsin.getMobileAppPageViewsPercentageB2B());
            this.totalTrafficByAsin.setPageViewsPercentage(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getPageViewsPercentage()) + trafficByAsin.getPageViewsPercentage());
            this.totalTrafficByAsin.setPageViewsPercentageB2B(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getPageViewsPercentageB2B()) + trafficByAsin.getPageViewsPercentageB2B());
            this.totalTrafficByAsin.setBuyBoxPercentage(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getBuyBoxPercentage()) + trafficByAsin.getBuyBoxPercentage());
            this.totalTrafficByAsin.setBuyBoxPercentageB2B(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getBuyBoxPercentageB2B()) + trafficByAsin.getBuyBoxPercentageB2B());
            this.totalTrafficByAsin.setUnitSessionPercentage(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getUnitSessionPercentage()) + trafficByAsin.getUnitSessionPercentage());
            this.totalTrafficByAsin.setUnitSessionPercentageB2B(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByAsin.getUnitSessionPercentageB2B()) + trafficByAsin.getUnitSessionPercentageB2B());
        }
        this.setTotalSalesByAsin(totalSalesByAsin);
        this.setTotalTrafficByAsin(totalTrafficByAsin);
    }
}
