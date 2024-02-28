package com.example.amazonagencytechtask.model;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesData {
    private BigDecimal amount;
    private CurrencyCode currencyCode;

    public enum CurrencyCode {
        USD,
        EUR
    }
}
