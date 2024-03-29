package com.bloodbank.apis.bloodstatistics.service;


import com.bloodbank.apis.bloodstatistics.model.BloodStatistics;
import com.bloodbank.apis.bloodstatistics.repository.BloodStatisticsRepository;
import jakarta.validation.ValidationException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloodStatisticsService {

  @Autowired
  public BloodStatisticsRepository bloodStatisticsRepository;

  public List<BloodStatistics> getAllBloodStatistics() {
    return bloodStatisticsRepository.findAll();
  }

  public BloodStatistics getBloodStatisticsById(Long id) {
    Optional<BloodStatistics> bloodStatisticsOptional = bloodStatisticsRepository.findById(id);
    return bloodStatisticsOptional.get();
  }

  public BloodStatistics getBloodStatisticsByBloodGroup(String bloodGroup) {
    Optional<BloodStatistics> bloodStatisticsOptional = bloodStatisticsRepository.findByBloodGroup(
        bloodGroup);
    return bloodStatisticsOptional.get();
  }

  public BloodStatistics createBloodStatistics(BloodStatistics newBloodStatics) {
    bloodStatisticsRepository.save(newBloodStatics);
    return newBloodStatics;
  }


  public BloodStatistics updateBloodStatistics(Long id, BloodStatistics bloodStatistics, boolean isDonor) {

    Optional<BloodStatistics> bloodStatisticsOptional = bloodStatisticsRepository.findById(id);

    BloodStatistics updateBloodStatics = bloodStatisticsOptional.get();
   // updateBloodStatics.setBloodGroup(bloodStatistics.getBloodGroup());
    if (isDonor) {
      updateBloodStatics.setQuantity(
          bloodStatistics.getQuantity() + updateBloodStatics.getQuantity());
    } else {
      //receiver
      if (bloodStatistics.getQuantity() <= updateBloodStatics.getQuantity()) {
        updateBloodStatics.setQuantity(
            updateBloodStatics.getQuantity() - bloodStatistics.getQuantity());
      } else {
        throw new ValidationException("Asking que. is more than available quantity.");
      }

      updateBloodStatics.setQuantity(
          updateBloodStatics.getQuantity() - bloodStatistics.getQuantity());
    }
    BloodStatistics updatedBloodStatistics = bloodStatisticsRepository.save(updateBloodStatics);
    return updatedBloodStatistics;
  }


  public void deleteBloodStatistics(Long id) {
    bloodStatisticsRepository.deleteById(id);
  }
}


