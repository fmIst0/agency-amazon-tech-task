package com.example.amazonagencytechtask.model.db_collections.statistics.salesData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesByDate {
    private SalesData orderedProductSales;
    private SalesData orderedProductSalesB2B;
    private Integer unitsOrdered;
    private Integer unitsOrderedB2B;
    private Integer totalOrderItems;
    private Integer totalOrderItemsB2B;
    private SalesData averageSalesPerOrderItem;
    private SalesData averageSalesPerOrderItemB2B;
    private Double averageUnitsPerOrderItem;
    private Double averageUnitsPerOrderItemB2B;
    private SalesData averageSellingPrice;
    private SalesData averageSellingPriceB2B;
    private Integer unitsRefunded;
    private Double refundRate;
    private Integer claimsGranted;
    private SalesData claimsAmount;
    private SalesData shippedProductSales;
    private Integer unitsShipped;
    private Integer ordersShipped;
}
