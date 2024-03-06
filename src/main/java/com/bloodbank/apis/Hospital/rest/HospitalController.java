package com.bloodbank.apis.Hospital.rest;

//public class hospitalcontroller {
//}
//package com.bloodbank.apis.hospital.controller;

import com.bloodbank.apis.Hospital.model.Hospital;
import com.bloodbank.apis.Hospital.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospitals")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    // Get all hospitals
    @GetMapping
    public ResponseEntity<List<Hospital>> getAllHospitals() {
        List<Hospital> hospitals = hospitalService.getAllHospitals();
        return new ResponseEntity<>(hospitals, HttpStatus.OK);
    }

    // Get a hospital by ID
    @GetMapping("/{hospitalId}")
    public ResponseEntity<Hospital> getHospitalById(@PathVariable int hospitalId) {
        Hospital hospital = hospitalService.getHospitalById(hospitalId);
        if (hospital != null) {
            return new ResponseEntity<>(hospital, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new hospital
    @PostMapping("/create")
    public ResponseEntity<Hospital> createHospital(@RequestBody Hospital newHospital) {
        Hospital createdHospital = hospitalService.createHospital(newHospital);
        return new ResponseEntity<>(createdHospital, HttpStatus.CREATED);
    }

    // Update an existing hospital
    @PutMapping("/{hospitalId}")
    public ResponseEntity<Hospital> updateHospital(@PathVariable int hospitalId, @RequestBody Hospital updatedHospital) {
        Hospital hospital = hospitalService.updateHospital(hospitalId, updatedHospital);
        if (hospital != null) {
            return new ResponseEntity<>(hospital, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a hospital by ID
//    @DeleteMapping("/{hospitalId}")
//    public ResponseEntity<Void> deleteHospital(@PathVariable int hospitalId) {
//        boolean deleted = hospitalService.deleteHospital(hospitalId);
//        if (deleted) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    @DeleteMapping("/{hospitalId}")
       public ResponseEntity<Void> deleteHospital(@PathVariable Long hospitalId) {
        boolean deleted = hospitalService.deleteHospital(hospitalId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

