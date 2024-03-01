package com.example.amazonagencytechtask.service;

import java.util.List;

public interface CachingService {
    void updateCache();

    void updateDataByAsinsCache(List<String> asins);

    void updateDataByDatesCache(List<String> dates);
}
