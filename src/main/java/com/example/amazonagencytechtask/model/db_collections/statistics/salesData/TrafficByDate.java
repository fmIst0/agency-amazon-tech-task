package com.example.amazonagencytechtask.model.db_collections.statistics.salesData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrafficByDate {
    private Integer browserPageViews;
    private Integer browserPageViewsB2B;
    private Integer mobileAppPageViews;
    private Integer mobileAppPageViewsB2B;
    private Integer pageViews;
    private Integer pageViewsB2B;
    private Integer browserSessions;
    private Integer browserSessionsB2B;
    private Integer mobileAppSessions;
    private Integer mobileAppSessionsB2B;
    private Integer sessions;
    private Integer sessionsB2B;
    private Double buyBoxPercentage;
    private Double buyBoxPercentageB2B;
    private Double orderItemSessionPercentage;
    private Double orderItemSessionPercentageB2B;
    private Double unitSessionPercentage;
    private Integer unitSessionPercentageB2B;
    private Integer averageOfferCount;
    private Integer averageParentItems;
    private Integer feedbackReceived;
    private Integer negativeFeedbackReceived;
    private Integer receivedNegativeFeedbackRate;
}
