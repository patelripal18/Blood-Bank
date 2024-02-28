package com.bloodbank.apis.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface hospitalRepository extends JpaRepository <hospitalRepository,Long>{
    Optional<hospitalRepository> finduserrepositoryByIdAndIsActive(Long id , Boolean isActive);
}
