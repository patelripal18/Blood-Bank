package com.bloodbank.apis.receiver.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface receiverRepository extends JpaRepository<receiverRepository,Long> {
    Optional<receiverRepository> finduserrepositoryByIdAndIsActive(Long id , Boolean isActive);
}

//public interface userrepository extends JpaRepository<com.bloodbank.apis.user.repo.userrepository,Long> {
//
//    Optional<User> finduserrepositoryByIdAndIsActive(Long id , Boolean isActive);
//
//}