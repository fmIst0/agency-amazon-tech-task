package com.example.amazonagencytechtask.service.scheduler;

import com.example.amazonagencytechtask.model.db_collections.Report;
import com.example.amazonagencytechtask.repository.ReportRepository;
import com.example.amazonagencytechtask.service.CachingService;
import com.example.amazonagencytechtask.service.FileReaderService;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomScheduler {
    private final CachingService cachingService;
    private final ReportRepository reportRepository;
    private final FileReaderService fileReaderService;

    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private ScheduledFuture<?> scheduledFuture;

    public void scheduleTask(long delayInMillis) {
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(true);
        }

        scheduledFuture = executorService.scheduleAtFixedRate(
                this::executeUpdating,
                0,
                delayInMillis,
                TimeUnit.MILLISECONDS);
    }

    private void executeUpdating() {
        updateReportFromFile();
        updateCache();
    }

    private void updateReportFromFile() {
        reportRepository.deleteAll();
        Report report = fileReaderService.readReportFromFile("src/main/resources/test_report.json");
        reportRepository.save(report);
    }

    private void updateCache() {
        cachingService.updateCache();
    }

    public void updateDataByAsinsCache(List<String> asins) {
        cachingService.updateDataByAsinsCache(asins);
    }

    public void updateDataByDatesCache(List<String> dates) {
        cachingService.updateDataByDatesCache(dates);
    }
}
