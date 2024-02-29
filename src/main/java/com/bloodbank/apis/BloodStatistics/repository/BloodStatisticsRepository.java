package com.bloodbank.apis.BloodStatistics.repository;
import com.bloodbank.apis.BloodStatistics.model.BloodStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BloodStatisticsRepository extends JpaRepository<BloodStatistics,Integer>{
//public interface BloodStatisticsRepository extends JpaRepository<BloodStatistics, Integer> {
    // You can add custom query methods if needed
}
