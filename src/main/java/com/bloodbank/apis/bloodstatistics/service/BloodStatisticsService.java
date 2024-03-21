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

  public Optional<BloodStatistics> getBloodStatisticsById(int id) {
    return bloodStatisticsRepository.findById(id);
  }

  public BloodStatistics addBloodStatistics(BloodStatistics bloodStatistics) {
    return bloodStatisticsRepository.save(bloodStatistics);
  }

  public Optional<BloodStatistics> updateBloodStatistics(int id, BloodStatistics updatedStatistics) {
    if (bloodStatisticsRepository.existsById(id)) {
      return Optional.of(bloodStatisticsRepository.save(updatedStatistics));
    } else {
      return Optional.empty();
    }
  }

  public void deleteBloodStatistics(int id) {
    bloodStatisticsRepository.deleteById(id);
  }

}


