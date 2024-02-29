package com.example.amazonagencytechtask.model.db_collections.statistics.summaryStatistics.byDate;

import com.example.amazonagencytechtask.model.db_collections.statistics.SalesAndTrafficByDate;
import com.example.amazonagencytechtask.model.db_collections.statistics.salesData.SalesByDate;
import com.example.amazonagencytechtask.model.db_collections.statistics.salesData.TrafficByDate;
import com.example.amazonagencytechtask.service.SummaryStatisticsCalcHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SummaryStatisticsByDate {
    private TotalSalesByDate totalSalesByDate;
    private TotalTrafficByDate totalTrafficByDate;
    @JsonIgnore
    private SummaryStatisticsCalcHelper summaryStatisticsCalcHelper;

    public SummaryStatisticsByDate(SummaryStatisticsCalcHelper summaryStatisticsCalcHelper) {
        this.summaryStatisticsCalcHelper = summaryStatisticsCalcHelper;
    }

    public void calculateSummaryStatisticsByDate(List<SalesAndTrafficByDate> salesAndTrafficByDates) {
        totalSalesByDate = new TotalSalesByDate();
        totalTrafficByDate = new TotalTrafficByDate();

        for (SalesAndTrafficByDate data : salesAndTrafficByDates) {
            SalesByDate salesByDate = data.getSalesByDate();
            TrafficByDate trafficByDate = data.getTrafficByDate();

            this.totalSalesByDate.setTotalOrderedProductSales(summaryStatisticsCalcHelper.addSalesData(totalSalesByDate.getTotalOrderedProductSales(), salesByDate.getOrderedProductSales()));
            this.totalSalesByDate.setTotalOrderedProductSalesB2B(summaryStatisticsCalcHelper.addSalesData(totalSalesByDate.getTotalOrderedProductSalesB2B(), salesByDate.getOrderedProductSalesB2B()));
            this.totalSalesByDate.setTotalUnitsOrdered(summaryStatisticsCalcHelper.getSafeValue(totalSalesByDate.getTotalUnitsOrdered()) + salesByDate.getUnitsOrdered());
            this.totalSalesByDate.setTotalUnitsOrderedB2B(summaryStatisticsCalcHelper.getSafeValue(totalSalesByDate.getTotalUnitsOrderedB2B()) + salesByDate.getUnitsOrderedB2B());
            this.totalSalesByDate.setAllTotalOrderItems(summaryStatisticsCalcHelper.getSafeValue(totalSalesByDate.getAllTotalOrderItems()) + salesByDate.getTotalOrderItems());
            this.totalSalesByDate.setAllTotalOrderItemsB2B(summaryStatisticsCalcHelper.getSafeValue(totalSalesByDate.getAllTotalOrderItemsB2B()) + salesByDate.getTotalOrderItemsB2B());
            this.totalSalesByDate.setTotalAverageUnitsPerOrderItem(summaryStatisticsCalcHelper.getSafeValue(totalSalesByDate.getTotalAverageUnitsPerOrderItem()) + salesByDate.getAverageUnitsPerOrderItem());
            this.totalSalesByDate.setTotalAverageUnitsPerOrderItemB2B(summaryStatisticsCalcHelper.getSafeValue(totalSalesByDate.getTotalAverageUnitsPerOrderItemB2B()) + salesByDate.getAverageUnitsPerOrderItemB2B());
            this.totalSalesByDate.setTotalAverageSalesPerOrderItem(summaryStatisticsCalcHelper.addSalesData(totalSalesByDate.getTotalAverageSalesPerOrderItem(), salesByDate.getAverageSalesPerOrderItem()));
            this.totalSalesByDate.setTotalAverageSalesPerOrderItemB2B(summaryStatisticsCalcHelper.addSalesData(totalSalesByDate.getTotalAverageSalesPerOrderItemB2B(), salesByDate.getAverageSalesPerOrderItemB2B()));
            this.totalSalesByDate.setTotalAverageSellingPrice(summaryStatisticsCalcHelper.addSalesData(totalSalesByDate.getTotalAverageSellingPrice(), salesByDate.getAverageSellingPrice()));
            this.totalSalesByDate.setTotalAverageSellingPriceB2B(summaryStatisticsCalcHelper.addSalesData(totalSalesByDate.getTotalAverageSellingPriceB2B(), salesByDate.getAverageSellingPriceB2B()));
            this.totalSalesByDate.setTotalUnitsRefunded(summaryStatisticsCalcHelper.getSafeValue(totalSalesByDate.getTotalUnitsRefunded()) + salesByDate.getUnitsRefunded());
            this.totalSalesByDate.setTotalRefundRate(summaryStatisticsCalcHelper.getSafeValue(totalSalesByDate.getTotalRefundRate()) + salesByDate.getRefundRate());
            this.totalSalesByDate.setTotalClaimsGranted(summaryStatisticsCalcHelper.getSafeValue(totalSalesByDate.getTotalClaimsGranted()) + salesByDate.getClaimsGranted());
            this.totalSalesByDate.setTotalClaimsAmount(summaryStatisticsCalcHelper.addSalesData(totalSalesByDate.getTotalClaimsAmount(), salesByDate.getClaimsAmount()));
            this.totalSalesByDate.setTotalShippedProductSales(summaryStatisticsCalcHelper.addSalesData(totalSalesByDate.getTotalShippedProductSales(), salesByDate.getShippedProductSales()));
            this.totalSalesByDate.setTotalUnitsShipped(summaryStatisticsCalcHelper.getSafeValue(totalSalesByDate.getTotalUnitsShipped()) + salesByDate.getUnitsShipped());
            this.totalSalesByDate.setTotalOrdersShipped(summaryStatisticsCalcHelper.getSafeValue(totalSalesByDate.getTotalOrdersShipped()) + salesByDate.getOrdersShipped());

            this.totalTrafficByDate.setTotalBrowserPageViews(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByDate.getTotalBrowserPageViews()) + trafficByDate.getBrowserPageViews());
            this.totalTrafficByDate.setTotalBrowserPageViewsB2B(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByDate.getTotalBrowserPageViewsB2B()) + trafficByDate.getBrowserPageViewsB2B());
            this.totalTrafficByDate.setTotalMobileAppPageViews(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByDate.getTotalMobileAppPageViews()) + trafficByDate.getMobileAppPageViews());
            this.totalTrafficByDate.setTotalMobileAppPageViewsB2B(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByDate.getTotalMobileAppPageViewsB2B()) + trafficByDate.getMobileAppPageViewsB2B());
            this.totalTrafficByDate.setTotalPageViews(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByDate.getTotalPageViews()) + trafficByDate.getPageViews());
            this.totalTrafficByDate.setTotalPageViewsB2B(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByDate.getTotalPageViewsB2B()) + trafficByDate.getPageViewsB2B());
            this.totalTrafficByDate.setTotalBrowserSessions(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByDate.getTotalBrowserSessions()) + trafficByDate.getBrowserSessions());
            this.totalTrafficByDate.setTotalBrowserSessionsB2B(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByDate.getTotalBrowserSessionsB2B()) + trafficByDate.getBrowserSessionsB2B());
            this.totalTrafficByDate.setTotalMobileAppSessions(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByDate.getTotalMobileAppSessions()) + trafficByDate.getMobileAppSessions());
            this.totalTrafficByDate.setTotalMobileAppSessionsB2B(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByDate.getTotalMobileAppSessionsB2B()) + trafficByDate.getMobileAppSessionsB2B());
            this.totalTrafficByDate.setTotalSessions(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByDate.getTotalSessions()) + trafficByDate.getSessions());
            this.totalTrafficByDate.setTotalSessionsB2B(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByDate.getTotalSessionsB2B()) + trafficByDate.getSessionsB2B());
            this.totalTrafficByDate.setTotalBuyBoxPercentage(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByDate.getTotalBuyBoxPercentage()) + trafficByDate.getBuyBoxPercentage());
            this.totalTrafficByDate.setTotalBuyBoxPercentageB2B(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByDate.getTotalBuyBoxPercentageB2B()) + trafficByDate.getBuyBoxPercentageB2B());
            this.totalTrafficByDate.setTotalOrderItemSessionPercentage(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByDate.getTotalOrderItemSessionPercentage()) + trafficByDate.getOrderItemSessionPercentage());
            this.totalTrafficByDate.setTotalOrderItemSessionPercentageB2B(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByDate.getTotalOrderItemSessionPercentageB2B()) + trafficByDate.getOrderItemSessionPercentageB2B());
            this.totalTrafficByDate.setTotalUnitSessionPercentage(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByDate.getTotalUnitSessionPercentage()) + trafficByDate.getUnitSessionPercentage());
            this.totalTrafficByDate.setTotalUnitSessionPercentageB2B(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByDate.getTotalUnitSessionPercentageB2B()) + trafficByDate.getUnitSessionPercentageB2B());
            this.totalTrafficByDate.setTotalAverageOfferCount(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByDate.getTotalAverageOfferCount()) + trafficByDate.getAverageOfferCount());
            this.totalTrafficByDate.setTotalAverageParentItems(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByDate.getTotalAverageParentItems()) + trafficByDate.getAverageParentItems());
            this.totalTrafficByDate.setTotalFeedbackReceived(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByDate.getTotalFeedbackReceived()) + trafficByDate.getFeedbackReceived());
            this.totalTrafficByDate.setTotalNegativeFeedbackReceived(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByDate.getTotalNegativeFeedbackReceived()) + trafficByDate.getNegativeFeedbackReceived());
            this.totalTrafficByDate.setTotalReceivedNegativeFeedbackRate(summaryStatisticsCalcHelper.getSafeValue(totalTrafficByDate.getTotalReceivedNegativeFeedbackRate()) + trafficByDate.getReceivedNegativeFeedbackRate());
        }
        this.setTotalSalesByDate(totalSalesByDate);
        this.setTotalTrafficByDate(totalTrafficByDate);
    }
}
