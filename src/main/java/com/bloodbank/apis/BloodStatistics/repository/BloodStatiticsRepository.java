package com.bloodbank.apis.BloodStatistics.repository;
import com.bloodbank.apis.BloodStatistics.model.BloodStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodStatiticsRepository {

   // package com.bloodbank.apis.BloodStatistics.repository;


    public interface BloodStatisticsRepository extends JpaRepository<BloodStatistics, Integer> {
        // You can add custom query methods if needed
    }

}
