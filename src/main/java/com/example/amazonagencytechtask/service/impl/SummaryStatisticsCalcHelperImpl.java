package com.example.amazonagencytechtask.service.impl;

import com.example.amazonagencytechtask.model.db_collections.statistics.salesData.SalesData;
import com.example.amazonagencytechtask.service.SummaryStatisticsCalcHelper;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class SummaryStatisticsCalcHelperImpl implements SummaryStatisticsCalcHelper {
    @Override
    public Integer getSafeValue(Integer value) {
        return value != null ? value : 0;
    }

    @Override
    public Double getSafeValue(Double value) {
        return value != null ? value : 0;
    }

    @Override
    public SalesData addSalesData(SalesData data1, SalesData data2) {
        if (data1 == null && data2 == null) {
            return null;
        } else if (data1 == null) {
            return data2;
        } else if (data2 == null) {
            return data1;
        }

        BigDecimal amount1 = data1.getAmount() != null ? data1.getAmount() : BigDecimal.ZERO;
        BigDecimal amount2 = data2.getAmount() != null ? data2.getAmount() : BigDecimal.ZERO;
        BigDecimal totalAmount = amount1.add(amount2);

        return new SalesData(totalAmount, data1.getCurrencyCode());
    }
}
