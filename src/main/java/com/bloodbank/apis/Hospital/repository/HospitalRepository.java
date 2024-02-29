package com.bloodbank.apis.Hospital.repository;

import com.bloodbank.apis.Hospital.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository <Hospital,Long>{
//    Optional<hospitalRepository> finduserrepositoryByIdAndIsActive(Long id , Boolean isActive);
}
