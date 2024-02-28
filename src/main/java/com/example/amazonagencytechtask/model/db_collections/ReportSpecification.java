package com.example.amazonagencytechtask.model.db_collections;

import com.example.amazonagencytechtask.model.ReportOptions;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "reportSpecifications")
public class ReportSpecification {
    @Id
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
