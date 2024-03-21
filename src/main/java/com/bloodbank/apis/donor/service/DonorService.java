package com.bloodbank.apis.donor.service;


import com.bloodbank.apis.donor.model.Donor;
import com.bloodbank.apis.donor.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonorService {

  @Autowired
  public DonorRepository donorRepository;


  public List<Donor> getAllDonors() {
    return donorRepository.findAll();
  }

  public Donor getDonorById(Long donorId) {
    Optional<Donor> donorOptional = donorRepository.findById(donorId);
    return donorOptional.get();
  }

  public Donor createDonor(Donor newDonor) {

    donorRepository.save(newDonor);
    return newDonor;
  }


  public Donor updateDonor(Long id, Donor donor) {
    Optional<Donor> donorOptional = donorRepository.findById(id);
    Donor updateDonor = donorOptional.get();
    updateDonor.setQuantity(donor.getQuantity());
    updateDonor.setBloodCollectDate(donor.getBloodCollectDate());
    updateDonor.setUserId(donor.getUserId());
    Donor updatedDonor = donorRepository.save(updateDonor);
    return updatedDonor;

  }


  public void deleteDonor(Long userId) {
    donorRepository.deleteById(userId);
  }
}

