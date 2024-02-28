package com.example.amazonagencytechtask.model.db_collections;

import com.example.amazonagencytechtask.model.SalesByAsin;
import com.example.amazonagencytechtask.model.TrafficByAsin;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "salesAndTrafficByAsin")
public class SalesAndTrafficByAsin {
    @Id
    private String id;
    private String parentAsin;
    private SalesByAsin salesByAsin;
    private TrafficByAsin trafficByAsin;
}
