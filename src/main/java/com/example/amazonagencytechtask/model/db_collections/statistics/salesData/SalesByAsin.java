package com.example.amazonagencytechtask.model.db_collections.statistics.salesData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesByAsin {
    private Integer unitsOrdered;
    private Integer unitsOrderedB2B;
    private SalesData orderedProductSales;
    private SalesData orderedProductSalesB2B;
    private Integer totalOrderItems;
    private Integer totalOrderItemsB2B;
}
