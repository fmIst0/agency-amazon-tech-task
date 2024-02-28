package com.example.amazonagencytechtask.model.db_collections;

import com.example.amazonagencytechtask.model.SalesData;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "salesAndTrafficByDate")
public class SalesAndTrafficByDate {
    @Id
    private String id;
    private String date;
    private SalesData salesByDate;
    private SalesData orderedProductSalesB2B;
    private Integer unitsOrdered;
    private Integer unitsOrderedB2B;
    private Integer totalOrderItems;
    private  Integer totalOrderItemsB2B;
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
