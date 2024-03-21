package com.bloodbank.apis.bloodstatistics.service;


import com.bloodbank.apis.bloodstatistics.model.BloodStatistics;

import com.bloodbank.apis.bloodstatistics.repository.BloodStatisticsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloodStatisticsService {

  @Autowired
  private BloodStatisticsRepository bloodStatisticsRepository;


  public List<BloodStatistics> getAllBloodStatistics() {
    return bloodStatisticsRepository.findAll();
  }

  public BloodStatistics getBloodStatisticsById(Long id) {
    Optional<BloodStatistics> bloodStatisticsOptional = bloodStatisticsRepository.findById(id);
    return bloodStatisticsOptional.get();
  }

  public BloodStatistics createBloodStatics(BloodStatistics newBloodStatics) {
    bloodStatisticsRepository.save(newBloodStatics);
    return newBloodStatics;
  }

  public BloodStatistics updateBloodStatistics(Long id, BloodStatistics bloodStatistics) {
    Optional<BloodStatistics> bloodStatisticsOptional = bloodStatisticsRepository.findById(id);
    BloodStatistics updateBloodStatics = bloodStatisticsOptional.get();
    updateBloodStatics.setBloodGroup(bloodStatistics.getBloodGroup());
    updateBloodStatics.setQuantity(bloodStatistics.getQuantity());
    BloodStatistics updatedBloodStatistics = bloodStatisticsRepository.save(updateBloodStatics);
    return updatedBloodStatistics;
  }

  public void deleteBloodStatistics(Long id) {
    bloodStatisticsRepository.deleteById(id);
  }
}


