package com.bloodbank.apis.receiver.service;
import com.bloodbank.apis.donor.model.Donor;
import com.bloodbank.apis.receiver.model.Receiver;
import com.bloodbank.apis.receiver.repository.ReceiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReceiverService {
   @Autowired
    private  ReceiverRepository receiverRepository;
    private List<Receiver> receivers = new ArrayList<>();
    // Get all receivers
    public List<Receiver> getAllReceivers() {
      return receiverRepository.findAll();
    }

    // Get a receiver by ID
    public Receiver getReceiverById(int receiverId) {
        Optional<Receiver> receiverOptional  = receiverRepository.findById(receiverId);
        return receiverOptional.get();
    }

    // Create a new receiver
    public Receiver createReceiver(Receiver newReceiver) {
        receiverRepository.save(newReceiver);
        return newReceiver;
    }

    // Update an existing receiver
    public Receiver updateReceiver(int receiverId, Receiver updatedReceiver) {

        Optional<Receiver> receiverOptional  = receiverRepository.findById(receiverId);
        receiverRepository.save(updatedReceiver);
        return updatedReceiver;
    }
    public boolean deleteReceiver(int receiverId) {
        receiverRepository.deleteById(receiverId);
        return true;
    }
}

