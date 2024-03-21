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

  public Donor getDonerById(Long donerId) {
    Optional<Donor> donorOptional = donorRepository.findById(donerId);
    return donorOptional.get();
  }

  public Donor createDonor(Donor newDonor) {
    newDonor.setId(newDonor.getId());
    donorRepository.save(newDonor);
    return newDonor;
  }


  public Donor updateDonor(Long Id, Donor updatedDonor) {
    Optional<Donor> donorOptional = donorRepository.findById(Id);
    Donor updateDonor = donorOptional.get();
    updateDonor.setUnit(updatedDonor.getUnit());
    updateDonor.setQuantity(updatedDonor.getQuantity());
    updateDonor.setBloodCollectDate(updatedDonor.getBloodCollectDate());
    updateDonor.setUserId(updatedDonor.getUserId());

    donorRepository.save(updateDonor);
    return updatedDonor;

  }


  public Boolean deleteDonor(Long userId) {
    donorRepository.deleteById(userId);
    return true;
  }
}

