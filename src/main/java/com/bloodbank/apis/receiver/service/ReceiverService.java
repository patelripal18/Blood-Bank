package com.bloodbank.apis.receiver.service;
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
    private final ReceiverRepository receiverRepository;
    private List<Receiver> receivers = new ArrayList<>();
    private int nextReceiverId = 1;

    public ReceiverService(ReceiverRepository receiverRepository) {
        this.receiverRepository = receiverRepository;
    }

    // Get all receivers
    public List<Receiver> getAllReceivers() {
        return receivers;
    }

    // Get a receiver by ID
    public Receiver getReceiverById(int receiverId) {
        // Implement logic to retrieve receiver by ID
        // Return null if not found
        Optional<Receiver> receiverOptional  = receiverRepository.findById(receiverId);
        return receiverOptional.get();
    }

    // Create a new receiver
    public Receiver createReceiver(Receiver newReceiver) {
              receiverRepository.save(newReceiver);
        receivers.add(newReceiver);
        return newReceiver;
    }

    // Update an existing receiver
    public Receiver updateReceiver(int receiverId, Receiver updatedReceiver) {

        Optional<Receiver> receiverOptional  = receiverRepository.findById(receiverId);
        updatedReceiver.setRId(receiverId);
        receiverRepository.save(updatedReceiver);
        receivers.add(updatedReceiver);
        return updatedReceiver;

    }


    public boolean deleteReceiver(int receiverId) {
        receiverRepository.deleteById(receiverId);
        return true;
    }
}

