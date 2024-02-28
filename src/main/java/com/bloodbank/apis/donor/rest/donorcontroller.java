package com.bloodbank.apis.donor.rest;

//public class donorcontroller {
//}
//package com.bloodbank.apis.donor.controller;

import com.bloodbank.apis.donor.model.donor;
import com.bloodbank.apis.donor.service.donorservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donors")
public class donorcontroller {

    @Autowired
    private donorservice donorService;

    // Get all donors
    @GetMapping
    public ResponseEntity<List<donor>> getAllDonors() {
        List<donor> donors = donorService.getAllDonors();
        return new ResponseEntity<>(donors, HttpStatus.OK);
    }

    // Get a donor by ID
    @GetMapping("/{donorId}")
    public ResponseEntity<donor> getDonorById(@PathVariable int donorId) {
        donor donor = donorService.getDonorById(donorId);
        if (donor != null) {
            return new ResponseEntity<>(donor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new donor
    @PostMapping("/create")
    public ResponseEntity<donor> createDonor(@RequestBody donor newDonor) {
        donor createdDonor = donorService.createDonor(newDonor);
        return new ResponseEntity<>(createdDonor, HttpStatus.CREATED);
    }

    // Update an existing donor
    @PutMapping("/{donorId}")
    public ResponseEntity<donor> updateDonor(@PathVariable int donorId, @RequestBody donor updatedDonor) {
        donor donor = donorService.updateDonor(donorId, updatedDonor);
        if (donor != null) {
            return new ResponseEntity<>(donor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a donor by ID
    @DeleteMapping("/{donorId}")
    public ResponseEntity<Void> deleteDonor(@PathVariable int donorId) {
        boolean deleted = donorService.deleteDonor(donorId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
