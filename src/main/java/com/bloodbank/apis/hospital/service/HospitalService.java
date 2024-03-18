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
    private final HospitalRepository hospitalRepository;
    private List<Hospital> hospitals = new ArrayList<>();
    private int nextHospitalId = 1;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    // Get all hospitals
    public List<Hospital> getAllHospitals() {
        return hospitals;
    }


    public Optional<Hospital> getHospitalById(int id) {
        return hospitalRepository.findById(Long.valueOf(id));
    }


    // Create a new hospital
    public Hospital createHospital(Hospital newHospital) {
      //  newHospital.setHospitalId(nextHospitalId++);
        hospitals.add(newHospital);
        hospitalRepository.save(newHospital);
        return newHospital;
    }

    // Update an existing hospital
    public Hospital updateHospital(int hospitalId, Hospital updatedHospital) {
        Optional<Hospital> hospitalOptional  = hospitalRepository.findById((long) hospitalId);
        updatedHospital.setHospitalId(hospitalId);
        hospitalRepository.save(updatedHospital);
        hospitals.add(updatedHospital);
        return updatedHospital;

    }

    // Delete a hospital by ID

    public boolean deleteHospital(Long hospitalId) {
        hospitalRepository.deleteById( hospitalId);
        return true;
    }
}

