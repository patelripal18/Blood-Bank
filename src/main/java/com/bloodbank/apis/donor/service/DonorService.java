package com.bloodbank.apis.donor.service;


import com.bloodbank.apis.donor.model.Donor;
import com.bloodbank.apis.donor.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DonorService {
    @Autowired
    public DonorRepository donorRepository;

    private List<Donor> donors = new ArrayList<>();
    private int nextDonorId = 1;

    // Get all donors
    public List<Donor> getAllDonors() {
        return donors;
    }


    // Create a new donor
    public Donor getDonerById(Long donerId) {
        Optional<Donor> donorOptional = donorRepository.findById(donerId);
        return donorOptional.get();
    }
    public Donor createDonor(Donor newDonor) {
        // newDonor.setDonorId(nextDonorId++);
        donors.add(newDonor);
        donorRepository.save(newDonor);
        return newDonor;
    }

    // Update an existing donor
    public Donor updateDonor(Long donorId, Donor updatedDonor) {

        Optional<Donor> donorOptional  = donorRepository.findById(donorId);
        updatedDonor.setDonorId(donorId);
        donorRepository.save(updatedDonor);
        donors.add(updatedDonor);
        return updatedDonor;

    }

    // Delete a donor by ID

    public Boolean deleteDonor(Long userId) {
        donorRepository.deleteById(userId);
        return true;
    }


}

