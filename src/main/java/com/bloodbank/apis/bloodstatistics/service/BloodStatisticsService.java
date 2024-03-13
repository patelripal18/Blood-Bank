package com.bloodbank.apis.bloodstatistics.service;
//package com.bloodbank.apis.BloodStatistics.service;

import com.bloodbank.apis.bloodstatistics.model.BloodStatistics;
//import com.bloodbank.apis.BloodStatistics.repository.BloodStatisticsRepository;
import com.bloodbank.apis.bloodstatistics.repository.BloodStatisticsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class BloodStatisticsService {

        private final BloodStatisticsRepository bloodStatisticsRepository;

        @Autowired
        public BloodStatisticsService(BloodStatisticsRepository bloodStatisticsRepository) {
            this.bloodStatisticsRepository = bloodStatisticsRepository;
        }

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
                updatedStatistics.setId(id);
                return Optional.of(bloodStatisticsRepository.save(updatedStatistics));
            } else {
                return Optional.empty(); // Handle not found case
            }
        }

        public void deleteBloodStatistics(int id) {
            bloodStatisticsRepository.deleteById(id);
        }

    }


