package com.bloodbank.apis.hospital.rest;

//public class hospitalcontroller {
//}
//package com.bloodbank.apis.hospital.controller;

import com.bloodbank.apis.hospital.model.hospital;
import com.bloodbank.apis.hospital.service.hospitalservice;
import com.bloodbank.apis.hospital.service.hospitalservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospitals")
public class hospitalcontroller {

    @Autowired
    private hospitalservice hospitalService;

    // Get all hospitals
    @GetMapping
    public ResponseEntity<List<hospital>> getAllHospitals() {
        List<hospital> hospitals = hospitalService.getAllHospitals();
        return new ResponseEntity<>(hospitals, HttpStatus.OK);
    }

    // Get a hospital by ID
    @GetMapping("/{hospitalId}")
    public ResponseEntity<hospital> getHospitalById(@PathVariable int hospitalId) {
        hospital hospital = hospitalService.getHospitalById(hospitalId);
        if (hospital != null) {
            return new ResponseEntity<>(hospital, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new hospital
    @PostMapping("/create")
    public ResponseEntity<hospital> createHospital(@RequestBody hospital newHospital) {
        hospital createdHospital = hospitalService.createHospital(newHospital);
        return new ResponseEntity<>(createdHospital, HttpStatus.CREATED);
    }

    // Update an existing hospital
    @PutMapping("/{hospitalId}")
    public ResponseEntity<hospital> updateHospital(@PathVariable int hospitalId, @RequestBody hospital updatedHospital) {
        hospital hospital = hospitalService.updateHospital(hospitalId, updatedHospital);
        if (hospital != null) {
            return new ResponseEntity<>(hospital, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a hospital by ID
    @DeleteMapping("/{hospitalId}")
    public ResponseEntity<Void> deleteHospital(@PathVariable int hospitalId) {
        boolean deleted = hospitalService.deleteHospital(hospitalId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

