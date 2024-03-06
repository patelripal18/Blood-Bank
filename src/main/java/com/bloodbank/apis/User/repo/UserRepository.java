package com.bloodbank.apis.User.repo;

import com.bloodbank.apis.User.model.BloodUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<BloodUser,Long>{

        //Optional<User> finduserrepositoryByIdAndIsActive(Long id ,Boolean isActive);

    }


