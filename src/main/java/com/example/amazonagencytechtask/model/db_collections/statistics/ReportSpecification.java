package com.example.amazonagencytechtask.model.db_collections.statistics;

import com.example.amazonagencytechtask.model.ReportOptions;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportSpecification {
    private String id;
    private ReportType reportType;
    private ReportOptions reportOptions;
    private String dataStartTime;
    private String dataEndTime;
    private Set<String> marketplaceIds;

    public enum ReportType {
        GET_SALES_AND_TRAFFIC_REPORT
    }
}
