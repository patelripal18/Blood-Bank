//package com.bloodbank.apis.hospital.service;

//public class hospitalservice {
//}
package com.bloodbank.apis.Hospital.service;

import com.bloodbank.apis.Hospital.model.Hospital;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalService {

    private List<Hospital> hospitals = new ArrayList<>();
    private int nextHospitalId = 1;

    // Get all hospitals
    public List<Hospital> getAllHospitals() {
        return hospitals;
    }

    // Get a hospital by ID
    public Hospital getHospitalById(int hospitalId) {
        // Implement logic to retrieve hospital by ID
        // Return null if not found
        return null;
    }

    // Create a new hospital
    public Hospital createHospital(Hospital newHospital) {
        newHospital.setHospitalId(nextHospitalId++);
        hospitals.add(newHospital);
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
    public boolean deleteHospital(int hospitalId) {
        for (int i = 0; i < hospitals.size(); i++) {
            Hospital h = hospitals.get(i);
            if (h.getHospitalId() == hospitalId) {
                hospitals.remove(i);
                return true;
            }
        }
        return false;
    }
}

