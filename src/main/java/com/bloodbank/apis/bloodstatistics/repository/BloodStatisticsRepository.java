package com.bloodbank.apis.bloodstatistics.repository;

import com.bloodbank.apis.bloodstatistics.model.BloodStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodStatisticsRepository extends JpaRepository<BloodStatistics, Long> {

}
