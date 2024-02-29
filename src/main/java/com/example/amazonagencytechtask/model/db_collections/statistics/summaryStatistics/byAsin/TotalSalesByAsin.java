package com.example.amazonagencytechtask.model.db_collections.statistics.summaryStatistics.byAsin;

import com.example.amazonagencytechtask.model.db_collections.statistics.salesData.SalesData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TotalSalesByAsin {
    private Integer totalUnitsOrdered;
    private Integer totalUnitsOrderedB2B;
    private SalesData totalOrderedProductSales;
    private SalesData totalOrderedProductSalesB2B;
    private Integer allTotalOrderItems;
    private Integer allTotalOrderItemsB2B;
}
