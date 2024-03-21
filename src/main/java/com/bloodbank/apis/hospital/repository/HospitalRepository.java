package com.bloodbank.apis.hospital.repository;

import com.bloodbank.apis.hospital.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {


}
