package com.bloodbank.apis.User.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserRepository,Long>{

        //Optional<User> finduserrepositoryByIdAndIsActive(Long id ,Boolean isActive);

    }


