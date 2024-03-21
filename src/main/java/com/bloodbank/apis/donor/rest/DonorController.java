package com.bloodbank.apis.donor.rest;

import com.bloodbank.apis.donor.model.Donor;
import com.bloodbank.apis.donor.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donors")
public class DonorController {

  @Autowired
  private DonorService donorService;


  @GetMapping
  public ResponseEntity<List<Donor>> getAllDonors() {
    List<Donor> donors = donorService.getAllDonors();
    return new ResponseEntity<>(donors, HttpStatus.OK);
  }


  @GetMapping("/{donorId}")
  public ResponseEntity<Donor> getDonorById(@PathVariable Long donorId) {
    Donor donor = donorService.getDonorById(donorId);
    if (donor != null) {
      return new ResponseEntity<>(donor, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  }


  @PostMapping("/create")
  public ResponseEntity<Donor> createDonor(@RequestBody Donor newDonor) {
    Donor createdDonor = donorService.createDonor(newDonor);
    return new ResponseEntity<>(createdDonor, HttpStatus.CREATED);

  }


  @PutMapping("/{donorId}")
  public ResponseEntity<Donor> updateDonor(@PathVariable Long donorId,
      @RequestBody Donor updatedDonor) {
    Donor donor = donorService.updateDonor(donorId, updatedDonor);
    if (donor != null) {
      return new ResponseEntity<>(donor, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @DeleteMapping("/{donorId}")
  public ResponseEntity<String> deleteDonor(@PathVariable Long donorId) {
    donorService.deleteDonor(donorId);
    return ResponseEntity.ok().body("Donor deleted successfully");
  }

}



