package com.bloodbank.apis.donor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface donorRepository extends JpaRepository<donorRepository,Long > {
    Optional<donorRepository>finduserrepositoryByIdAndIsActive(Long id , Boolean isActive);
}
