//package com.bloodbank.apis.hospital.service;

//public class hospitalservice {
//}
package com.bloodbank.apis.hospital.service;

import com.bloodbank.apis.donor.model.Donor;
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




    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();

    }


    public Hospital getHospitalById(Long id) {
        return hospitalRepository.findById(id).get();
    }



    public Hospital createHospital(Hospital newHospital) {
        hospitalRepository.save(newHospital);
        return newHospital;
    }

    // Update an existing hospital
    public Hospital updateHospital(Long hospitalId, Hospital updatedHospital) {

        Optional<Hospital> hospitalOptional  = hospitalRepository.findById(hospitalId);
        Hospital updateHospital = hospitalOptional.get();
        updateHospital.setHospitalName(updatedHospital.getHospitalName());
        updateHospital.setHospitalAddress(updatedHospital.getHospitalAddress());
        hospitalRepository.save(updatedHospital);
        return updatedHospital;

    }

    // Delete a hospital by ID

    public boolean deleteHospital(Long hospitalId) {
        hospitalRepository.deleteById( hospitalId);
        return true;
    }
}

