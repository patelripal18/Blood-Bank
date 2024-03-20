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

  public List<Donor> getAllDonors() {
    return donorRepository.findAll();
  }


  // Create a new donor
  public Donor getDonerById(Long donerId) {
    Optional<Donor> donorOptional = donorRepository.findById(donerId);
    return donorOptional.get();
  }

  public Donor createDonor(Donor newDonor) {
    newDonor.setId(newDonor.getId());
    ;

    donors.add(newDonor);
    donorRepository.save(newDonor);
    return newDonor;
  }

  // Update an existing donor
  public Donor updateDonor(Long Id, Donor updatedDonor) {
    Optional<Donor> donorOptional = donorRepository.findById(Id);
    Donor updateDonor = donorOptional.get();
    updateDonor.setUnit(updatedDonor.getUnit());
    updateDonor.setQuantity(updatedDonor.getQuantity());
    updateDonor.setBloodCollectDate(updatedDonor.getBloodCollectDate());
    updateDonor.setUserId(updateDonor.getUserId());
    updateDonor.setUnit(updateDonor.getUnit());
    donorRepository.save(updateDonor);
    //donors.add(updatedDonor);
    return updatedDonor;

  }

  // Delete a donor by ID
  public Boolean deleteDonor(Long userId) {
    donorRepository.deleteById(userId);
    return true;
  }
}

