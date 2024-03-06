package com.bloodbank.apis.BloodStatistics.rest;
import com.bloodbank.apis.BloodStatistics.model.BloodStatistics;
//import com.bloodbank.apis.bloodstatistics.model.BloodStatistics;
import com.bloodbank.apis.BloodStatistics.service.BloodStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//@Autowired
@RestController
@RequestMapping("/api/bloodstatistics")
public class BloodStatisticsController {
    @Autowired
    private final BloodStatisticsService bloodStatisticsService;
 //   @Autowired
    public BloodStatisticsController(BloodStatisticsService bloodStatisticsService) {
        this.bloodStatisticsService = bloodStatisticsService;
    }
    @GetMapping
    public Class<? extends BloodStatisticsService> getAllBloodStatistics() {
        return bloodStatisticsService.getClass();
    }

    @GetMapping("/{BloodStstisticsid}")
    public BloodStatistics getBloodStatisticsById(@PathVariable int id) {
        return bloodStatisticsService.getBloodStatisticsById(id).orElse(null);
    }

    @PostMapping
    public BloodStatistics addBloodStatistics(@RequestBody BloodStatistics bloodStatistics) {
        return bloodStatisticsService.addBloodStatistics(bloodStatistics);
    }

    @PutMapping("/{BloodStatisticsid}")
    public BloodStatistics updateBloodStatistics(@PathVariable int id, @RequestBody BloodStatistics updatedStatistics) {
        return bloodStatisticsService.updateBloodStatistics(id, updatedStatistics).orElse(null);
    }

    @DeleteMapping("/{BloodStatisticsid}")
    public void deleteBloodStatistics(@PathVariable int id) {

        bloodStatisticsService.deleteBloodStatistics(id);
    }
}



