package com.bloodbank.apis.user.repository;

import com.bloodbank.apis.user.model.BloodUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodUserRepository extends JpaRepository<BloodUser, Long> {


}


