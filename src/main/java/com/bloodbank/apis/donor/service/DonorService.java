package com.bloodbank.apis.donor.service;


import com.bloodbank.apis.bloodstatistics.model.BloodStatistics;
import com.bloodbank.apis.bloodstatistics.repository.BloodStatisticsRepository;
import com.bloodbank.apis.bloodstatistics.service.BloodStatisticsService;
import com.bloodbank.apis.donor.model.Donor;
import com.bloodbank.apis.donor.repository.DonorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonorService {

  @Autowired
  public DonorRepository donorRepository;

  @Autowired
  public BloodStatisticsRepository bloodStatisticsRepository;

  @Autowired
  public BloodStatisticsService bloodStatisticsService;

  public List<Donor> getAllDonors() {
    return donorRepository.findAll();
  }

  public Donor getDonorById(Long donorId) {
    Optional<Donor> donorOptional = donorRepository.findById(donorId);
    return donorOptional.get();
  }

  public Donor createDonor(Donor newDonor) {
    BloodStatistics bloodStatistics = bloodStatisticsService.getBloodStatisticsByBloodGroup(
        newDonor.getBloodGroup());
    //update stats
    if (bloodStatistics == null){
      BloodStatistics bs = new BloodStatistics();
      bs.setQuantity(newDonor.getQuantity());
      bs.setBloodGroup(newDonor.getBloodGroup());
      bloodStatisticsService.createBloodStatistics(bs);
    }else {

      bloodStatistics.setQuantity(newDonor.getQuantity());
      bloodStatisticsService.updateBloodStatistics(bloodStatistics.getId(), bloodStatistics,true);
    }
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

    BloodStatistics stats = bloodStatisticsService.getBloodStatisticsByBloodGroup("A+");
    if (stats == null){
      BloodStatistics bs = new BloodStatistics();
      bs.setQuantity(1);
      bs.setBloodGroup("A+");
      bloodStatisticsService.createBloodStatistics(bs);
    }else {
      bloodStatisticsService.updateBloodStatistics(stats.getId(), stats,true);
    }
    //update stats
    return updatedDonor;

  }


  public void deleteDonor(Long userId) {
    donorRepository.deleteById(userId);
  }
}

