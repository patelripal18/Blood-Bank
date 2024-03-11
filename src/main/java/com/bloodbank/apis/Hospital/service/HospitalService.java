//package com.bloodbank.apis.hospital.service;

//public class hospitalservice {
//}
package com.bloodbank.apis.Hospital.service;

import com.bloodbank.apis.Hospital.model.Hospital;
import com.bloodbank.apis.Hospital.repository.HospitalRepository;
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
    // Get a hospital by ID
//    public Receiver getHospitalById(int hospitalId) {
//        // Implement logic to retrieve hospital by ID
//        // Return null if not found
//        //return null;
//        Optional<Receiver> receiverOptional  = hospitalRepository.findById(hospitalId);
//        return receiverOptional.get();
//    }

    // Create a new hospital
    public Hospital createHospital(Hospital newHospital) {
      //  newHospital.setHospitalId(nextHospitalId++);
        hospitals.add(newHospital);
        hospitalRepository.save(newHospital);
        return newHospital;
    }

    // Update an existing hospital
    public Hospital updateHospital(int hospitalId, Hospital updatedHospital) {
        for (int i = 0; i < hospitals.size(); i++) {
            Hospital h = hospitals.get(i);
            if (h.getHospitalId() == hospitalId) {
                updatedHospital.setHospitalId(hospitalId);
                hospitals.set(i, updatedHospital);
                return updatedHospital;
            }
        }
        return null;
    }

    // Delete a hospital by ID
//    public boolean deleteHospital(int hospitalId) {
//        for (int i = 0; i < hospitals.size(); i++) {
//            Hospital h = hospitals.get(i);
//            if (h.getHospitalId() == hospitalId) {
//                hospitals.remove(i);
//                return true;
//            }
//        }
//        return false;
    public boolean deleteHospital(Long hospitalId) {
        hospitalRepository.deleteById( hospitalId);
        return true;
    }
}

