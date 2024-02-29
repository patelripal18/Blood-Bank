package com.bloodbank.apis.Receiver.service;

//public class receiverservice {
//}
//package com.bloodbank.apis.receiver.service;

import com.bloodbank.apis.Receiver.model.Receiver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReceiverService {

    private List<Receiver> receivers = new ArrayList<>();
    private int nextReceiverId = 1;

    // Get all receivers
    public List<Receiver> getAllReceivers() {
        return receivers;
    }

    // Get a receiver by ID
    public Receiver getReceiverById(int receiverId) {
        // Implement logic to retrieve receiver by ID
        // Return null if not found
        return null;
    }

    // Create a new receiver
    public Receiver createReceiver(Receiver newReceiver) {
        newReceiver.setRId(nextReceiverId++);
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
    public boolean deleteReceiver(int receiverId) {
        for (int i = 0; i < receivers.size(); i++) {
            Receiver r = receivers.get(i);
            if (r.getRId() == receiverId) {
                receivers.remove(i);
                return true;
            }
        }
        return false;
    }
}
