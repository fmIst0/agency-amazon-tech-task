package com.example.amazonagencytechtask.model.db_collections.statistics.salesData;

import com.example.amazonagencytechtask.model.CurrencyCode;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SalesData {
    private BigDecimal amount;
    private CurrencyCode currencyCode;
}