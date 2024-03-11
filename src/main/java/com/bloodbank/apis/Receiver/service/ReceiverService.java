package com.bloodbank.apis.Receiver.service;

//public class receiverservice {
//}
//package com.bloodbank.apis.receiver.service;

import com.bloodbank.apis.Receiver.model.Receiver;
import com.bloodbank.apis.Receiver.repository.ReceiverRepository;
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
       // newReceiver.setRId(nextReceiverId++);
        receiverRepository.save(newReceiver);
        receivers.add(newReceiver);
        return newReceiver;
    }

    // Update an existing receiver
    public Receiver updateReceiver(int receiverId, Receiver updatedReceiver) {
        for (int i = 0; i < receivers.size(); i++) {
            Receiver r = receivers.get(i);
            if (r.getRId() == receiverId) {
                updatedReceiver.setRId(receiverId);
                receivers.set(i, updatedReceiver);
                return updatedReceiver;
            }
        }
        return null;
    }

    // Delete a receiver by ID
//    public boolean deleteReceiver(int receiverId) {
//        for (int i = 0; i < receivers.size(); i++) {
//            Receiver r = receivers.get(i);
//            if (r.getRId() == receiverId) {
//                receivers.remove(i);
//                return true;
//            }
//        }
//        return false;
  //  }
    public boolean deleteReceiver(int receiverId) {
        receiverRepository.deleteById(receiverId);
        return true;
    }
}

