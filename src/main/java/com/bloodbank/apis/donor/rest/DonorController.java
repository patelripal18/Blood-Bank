package com.bloodbank.apis.donor.rest;

//public class donorcontroller {
//}
//package com.bloodbank.apis.donor.controller;

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

    // Get all donors
    @GetMapping
    public ResponseEntity<List<Donor>> getAllDonors() {
        List<Donor> donors = donorService.getAllDonors();
        return new ResponseEntity<>(donors, HttpStatus.OK);
    }

    // Get a donor by ID
    @GetMapping("/{donorId}")
    public ResponseEntity<Donor> getDonorById(@PathVariable Long donorId) {
        Donor donor = donorService.getDonerById(donorId);
        if (donor != null) {
            return new ResponseEntity<>(donor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
     //   return donorService.getBloodStatisticsById(id).orElse(null);
//        Donor donor = donorService.getDonorById(donorId);
//        if (donor != null) {
//            return new ResponseEntity<>(donor, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//      }
    }

    // Create a new donor
    @PostMapping("/create")
    public ResponseEntity<Donor> createDonor(@RequestBody Donor newDonor) {
        Donor createdDonor = donorService.createDonor(newDonor);
        return new ResponseEntity<>(createdDonor, HttpStatus.CREATED);

    }

    // Update an existing donor
    @PutMapping("/{donorId}")
    public ResponseEntity<String> updateDonor(@PathVariable Long donorId, @RequestBody Donor updatedDonor) {
        Donor donor = donorService.updateDonor(donorId, updatedDonor);
        if (donor != null) {
           // return ResponseEntity.ok().body("Donor updated successfully");

            return new ResponseEntity<>( HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a donor by ID
//    @DeleteMapping("/{donorId}")
//    public ResponseEntity<Void> deleteDonor(@PathVariable int donorId) {
//        boolean deleted = donorService.deleteDonor(donorId);
//        if (deleted) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    @DeleteMapping("/{donorId}")
  public ResponseEntity<String> deleteDonor(@PathVariable Long donorId) {
        boolean deleted = donorService.deleteDonor(donorId);
        if(deleted) {
            return ResponseEntity.ok().body("Donor deleted successfully");
        }else {
            return ResponseEntity.ok().body("Donor not found");
        }
       // return new ResponseEntity<>(HttpStatus.OK);
    }
    }
