package com.example.amazonagencytechtask.model.db_collections;

import com.example.amazonagencytechtask.model.db_collections.statistics.ReportSpecification;
import com.example.amazonagencytechtask.model.db_collections.statistics.SalesAndTrafficByAsin;
import com.example.amazonagencytechtask.model.db_collections.statistics.SalesAndTrafficByDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "reports")
public class Report {
    @Id
    private String id;
    private ReportSpecification reportSpecification;
    private List<SalesAndTrafficByAsin> salesAndTrafficByAsin;
    private List<SalesAndTrafficByDate> salesAndTrafficByDate;
}
