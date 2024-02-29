package com.bloodbank.apis.BloodStatistics.rest;
import com.bloodbank.apis.bloodstatistics.model.BloodStatistics;
import com.bloodbank.apis.bloodstatistics.service.BloodStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class BloodStstisticsController<BloodStatisticsService> {

    private final BloodStatisticsService bloodStatisticsService;

    @Autowired
    public BloodStatisticsController(BloodStatisticsService bloodStatisticsService) {
        this.bloodStatisticsService = bloodStatisticsService;
    }

    @GetMapping
    public List<BloodStatistics> getAllBloodStatistics() {
        return bloodStatisticsService.getClass();
    }

    @GetMapping("/{id}")
    public BloodStatistics getBloodStatisticsById(@PathVariable int id) {
        return bloodStatisticsService.getBloodStatisticsById(id).orElse(null);
    }

    @PostMapping
    public BloodStatistics addBloodStatistics(@RequestBody BloodStatistics bloodStatistics) {
        return bloodStatisticsService.addBloodStatistics(bloodStatistics);
    }

    @PutMapping("/{id}")
    public BloodStatistics updateBloodStatistics(@PathVariable int id, @RequestBody BloodStatistics updatedStatistics) {
        return bloodStatisticsService.updateBloodStatistics(id, updatedStatistics).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteBloodStatistics(@PathVariable int id) {
        bloodStatisticsService.deleteBloodStatistics(id);
    }
}
}
