package com.bloodbank.apis.receiver.repository;

import com.bloodbank.apis.receiver.model.Receiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiverRepository extends JpaRepository<Receiver, Integer> {
//    Optional<receiverRepository> finduserrepositoryByIdAndIsActive(Long id , Boolean isActive);
}

