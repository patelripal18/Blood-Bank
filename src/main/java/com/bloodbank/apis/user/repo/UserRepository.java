package com.bloodbank.apis.user.repo;

import com.bloodbank.apis.user.model.BloodUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<BloodUser,Long>{

    //Optional<User> finduserrepositoryByIdAndIsActive(Long id ,Boolean isActive);

    }


