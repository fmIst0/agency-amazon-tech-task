package com.example.amazonagencytechtask.model.db_collections.statistics.summaryStatistics.byDate;

import com.example.amazonagencytechtask.model.db_collections.statistics.salesData.SalesData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TotalSalesByDate {
    private SalesData totalOrderedProductSales;
    private SalesData totalOrderedProductSalesB2B;
    private Integer totalUnitsOrdered;
    private Integer totalUnitsOrderedB2B;
    private Integer allTotalOrderItems;
    private Integer allTotalOrderItemsB2B;
    private SalesData totalAverageSalesPerOrderItem;
    private SalesData totalAverageSalesPerOrderItemB2B;
    private Double totalAverageUnitsPerOrderItem;
    private Double totalAverageUnitsPerOrderItemB2B;
    private SalesData totalAverageSellingPrice;
    private SalesData totalAverageSellingPriceB2B;
    private Integer totalUnitsRefunded;
    private Double totalRefundRate;
    private Integer totalClaimsGranted;
    private SalesData totalClaimsAmount;
    private SalesData totalShippedProductSales;
    private Integer totalUnitsShipped;
    private Integer totalOrdersShipped;
}
