//package com.bloodbank.apis.hospital.service;

//public class hospitalservice {
//}
package com.bloodbank.apis.hospital.service;

import com.bloodbank.apis.hospital.model.Hospital;
import com.bloodbank.apis.hospital.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {
     @Autowired
    private HospitalRepository hospitalRepository;
    private List<Hospital> hospitals = new ArrayList<>();



    // Get all hospitals
    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();

    }


    public Optional<Hospital> getHospitalById(Long id) {
        return hospitalRepository.findById(id);
    }


    // Create a new hospital
    public Hospital createHospital(Hospital newHospital) {
        hospitalRepository.save(newHospital);
        return newHospital;
    }

    // Update an existing hospital
    public Hospital updateHospital(Long hospitalId, Hospital updatedHospital) {
        Optional<Hospital> hospitalOptional  = hospitalRepository.findById((long) hospitalId);
        hospitalRepository.save(updatedHospital);
        return updatedHospital;

    }

    // Delete a hospital by ID

    public boolean deleteHospital(Long hospitalId) {
        hospitalRepository.deleteById( hospitalId);
        return true;
    }
}

