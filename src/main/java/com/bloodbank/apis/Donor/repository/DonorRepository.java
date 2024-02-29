package com.bloodbank.apis.Donor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bloodbank.apis.Donor.model.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor,Long > {
//    Optional<donorRepository>findByIdAndIsActive(Long id , Boolean isActive);
}
