//package com.bloodbank.apis.hospital.service;

//public class hospitalservice {
//}
package com.bloodbank.apis.hospital.service;

import com.bloodbank.apis.hospital.model.hospital;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class hospitalservice {

    private List<hospital> hospitals = new ArrayList<>();
    private int nextHospitalId = 1;

    // Get all hospitals
    public List<hospital> getAllHospitals() {
        return hospitals;
    }

    // Get a hospital by ID
    public hospital getHospitalById(int hospitalId) {
        // Implement logic to retrieve hospital by ID
        // Return null if not found
        return null;
    }

    // Create a new hospital
    public hospital createHospital(hospital newHospital) {
        newHospital.setHospitalId(nextHospitalId++);
        hospitals.add(newHospital);
        return newHospital;
    }

    // Update an existing hospital
    public hospital updateHospital(int hospitalId, hospital updatedHospital) {
        for (int i = 0; i < hospitals.size(); i++) {
            hospital h = hospitals.get(i);
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
            hospital h = hospitals.get(i);
            if (h.getHospitalId() == hospitalId) {
                hospitals.remove(i);
                return true;
            }
        }
        return false;
    }
}

