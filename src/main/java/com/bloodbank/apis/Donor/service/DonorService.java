package com.bloodbank.apis.Donor.service;

//public class donorservice {
//}
//package com.bloodbank.apis.donor.service;

import com.bloodbank.apis.Donor.model.Donor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DonorService {

    private List<Donor> donors = new ArrayList<>();
    private int nextDonorId = 1;

    // Get all donors
    public List<Donor> getAllDonors() {
        return donors;
    }

    // Get a donor by ID
    public Donor getDonorById(int donorId) {
        // Implement logic to retrieve donor by ID
        // Return null if not found
        return null;
    }

    // Create a new donor
    public Donor createDonor(Donor newDonor) {
        newDonor.setDonorId(nextDonorId++);
        donors.add(newDonor);
        return newDonor;
    }

    // Update an existing donor
    public Donor updateDonor(int donorId, Donor updatedDonor) {
        for (int i = 0; i < donors.size(); i++) {
            Donor d = donors.get(i);
            if (d.getDonorId() == donorId) {
                updatedDonor.setDonorId(donorId);
                donors.set(i, updatedDonor);
                return updatedDonor;
            }
        }
        return null;
    }

    // Delete a donor by ID
    public boolean deleteDonor(int donorId) {
        for (int i = 0; i < donors.size(); i++) {
            Donor d = donors.get(i);
            if (d.getDonorId() == donorId) {
                donors.remove(i);
                return true;
            }
        }
        return false;
    }
}

