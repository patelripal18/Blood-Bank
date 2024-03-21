package com.bloodbank.apis.hospital.rest;

import com.bloodbank.apis.hospital.model.Hospital;
import com.bloodbank.apis.hospital.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hospitals")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;


    @GetMapping
    public ResponseEntity<List<Hospital>> getAllHospitals() {
        List<Hospital> hospitals = hospitalService.getAllHospitals();
        return new ResponseEntity<>(hospitals, HttpStatus.OK);
    }


    @GetMapping("/{hospitalId}")
    public Hospital getHospitalById(@PathVariable Long hospitalId) {
        Hospital hospital = hospitalService.getHospitalById(hospitalId);
        return hospitalService.getHospitalById(hospitalId);

    }


    @PostMapping("/create")
    public ResponseEntity<Hospital> createHospital(@RequestBody Hospital newHospital) {
        Hospital createdHospital = hospitalService.createHospital(newHospital);
        return new ResponseEntity<>(createdHospital, HttpStatus.CREATED);
    }


    @PutMapping("/{hospitalId}")
    public ResponseEntity<Hospital> updateHospital(@PathVariable Long hospitalId, @RequestBody Hospital updatedHospital) {
        Hospital hospital = hospitalService.updateHospital(hospitalId, updatedHospital);
        if (hospital != null) {
            return new ResponseEntity<>(hospital, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @DeleteMapping("/{hospitalId}")
       public ResponseEntity<String> deleteHospital(@PathVariable Long hospitalId) {
        boolean deleted = hospitalService.deleteHospital(hospitalId);
        return ResponseEntity.ok().body("HospitalId deleted successfully");
    }
}

