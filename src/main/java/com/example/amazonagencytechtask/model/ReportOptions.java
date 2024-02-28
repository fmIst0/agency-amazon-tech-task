package com.example.amazonagencytechtask.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportOptions {
    private DateGranularity dateGranularity;
    private AsinGranularity asinGranularity;

    public enum DateGranularity {
        DAY,
        WEEK,
        MONTH,
        YEAR
    }

    public enum AsinGranularity {
        PARENT,
        CHILD
    }
}
