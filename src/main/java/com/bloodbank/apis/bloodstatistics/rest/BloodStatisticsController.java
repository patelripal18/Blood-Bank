package com.bloodbank.apis.bloodstatistics.rest;

import com.bloodbank.apis.bloodstatistics.model.BloodStatistics;
import com.bloodbank.apis.bloodstatistics.service.BloodStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bloodStatistics")
public class BloodStatisticsController {

  @Autowired
  private BloodStatisticsService bloodStatisticsService;

  @GetMapping
  public ResponseEntity<List<BloodStatistics>> getAllBloodStatistics() {
    List<BloodStatistics> bloodStatistics = bloodStatisticsService.getAllBloodStatistics();
    return new ResponseEntity<>(bloodStatistics, HttpStatus.OK);

  }


  @GetMapping("/{id}")
  public ResponseEntity<BloodStatistics> getBloodStatisticsById(@PathVariable Long id) {
//    try {
      BloodStatistics bloodStatistics = bloodStatisticsService.getBloodStatisticsById(id);
//    }
//    catch (){
//      System.out.println("not able"+e);
//    }
    if (bloodStatistics != null) {
      return new ResponseEntity<>(bloodStatistics, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  }

  @PostMapping
  public ResponseEntity<BloodStatistics> createBloodStatistics(@RequestBody BloodStatistics newbloodStatistics) {
    BloodStatistics createdbloodStatics = bloodStatisticsService.createBloodStatistics(
        newbloodStatistics);
    return new ResponseEntity<>(createdbloodStatics, HttpStatus.CREATED);

  }

  @PutMapping("/{id}")
  public ResponseEntity<BloodStatistics> updateBloodStatistics(@PathVariable Long id,
      @RequestBody BloodStatistics updatedStatistics) {
    BloodStatistics bloodStatistics = bloodStatisticsService.updateBloodStatistics(id, updatedStatistics, null);
    if (bloodStatistics != null) {
      return new ResponseEntity<>(bloodStatistics, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteBloodStatistics(@PathVariable Long id) {
    bloodStatisticsService.deleteBloodStatistics(id);
    return ResponseEntity.ok().body("BloodStatisticsId deleted successfully");
  }
}



