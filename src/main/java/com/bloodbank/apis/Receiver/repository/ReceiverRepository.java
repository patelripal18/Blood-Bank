package com.bloodbank.apis.Receiver.repository;

import com.bloodbank.apis.Receiver.model.Receiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiverRepository extends JpaRepository<Receiver, Integer> {
//    Optional<receiverRepository> finduserrepositoryByIdAndIsActive(Long id , Boolean isActive);
}

