package com.example.amazonagencytechtask.model.db_collections.statistics.summaryStatistics.byDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TotalTrafficByDate {
    private Integer totalBrowserPageViews;
    private Integer totalBrowserPageViewsB2B;
    private Integer totalMobileAppPageViews;
    private Integer totalMobileAppPageViewsB2B;
    private Integer totalPageViews;
    private Integer totalPageViewsB2B;
    private Integer totalBrowserSessions;
    private Integer totalBrowserSessionsB2B;
    private Integer totalMobileAppSessions;
    private Integer totalMobileAppSessionsB2B;
    private Integer totalSessions;
    private Integer totalSessionsB2B;
    private Double totalBuyBoxPercentage;
    private Double totalBuyBoxPercentageB2B;
    private Double totalOrderItemSessionPercentage;
    private Double totalOrderItemSessionPercentageB2B;
    private Double totalUnitSessionPercentage;
    private Integer totalUnitSessionPercentageB2B;
    private Integer totalAverageOfferCount;
    private Integer totalAverageParentItems;
    private Integer totalFeedbackReceived;
    private Integer totalNegativeFeedbackReceived;
    private Integer totalReceivedNegativeFeedbackRate;
}
