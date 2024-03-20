package com.bloodbank.apis.bloodstatistics.rest;
import com.bloodbank.apis.bloodstatistics.model.BloodStatistics;
//import com.bloodbank.apis.bloodstatistics.model.BloodStatistics;
import com.bloodbank.apis.bloodstatistics.service.BloodStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bloodstatistics")
public class BloodStatisticsController {

    @Autowired
    private BloodStatisticsService bloodStatisticsService;
  @GetMapping
    public List<BloodStatistics> getAllBloodStatistics() {
        return bloodStatisticsService.getAllBloodStatistics();
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
    public ResponseEntity<String> deleteBloodStatistics(@PathVariable int id) {

        bloodStatisticsService.deleteBloodStatistics(id);
        return ResponseEntity.ok().body("BloodStatisticsId deleted successfully");
    }
}



