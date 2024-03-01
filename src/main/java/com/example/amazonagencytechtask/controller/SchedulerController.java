package com.example.amazonagencytechtask.controller;

import com.example.amazonagencytechtask.service.scheduler.CustomScheduler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/scheduler")
public class SchedulerController {
    private final CustomScheduler customScheduler;

    @PutMapping("/{delayInMillis}")
    public void updateScheduler(@PathVariable long delayInMillis) {
        customScheduler.scheduleTask(delayInMillis);
    }
}
