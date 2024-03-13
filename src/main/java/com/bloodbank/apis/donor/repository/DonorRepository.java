package com.bloodbank.apis.donor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bloodbank.apis.donor.model.Donor;

import java.util.Optional;

@Repository
public interface DonorRepository extends JpaRepository<Donor,Long > {
//    Optional<donorRepository>findByIdAndIsActive(Long id , Boolean isActive);
    Optional<Donor> findByDonorId(Long donerId);
}