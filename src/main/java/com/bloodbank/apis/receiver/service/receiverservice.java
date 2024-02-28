package com.bloodbank.apis.receiver.service;

//public class receiverservice {
//}
//package com.bloodbank.apis.receiver.service;

import com.bloodbank.apis.receiver.model.receiver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class receiverservice {

    private List<receiver> receivers = new ArrayList<>();
    private int nextReceiverId = 1;

    // Get all receivers
    public List<receiver> getAllReceivers() {
        return receivers;
    }

    // Get a receiver by ID
    public receiver getReceiverById(int receiverId) {
        // Implement logic to retrieve receiver by ID
        // Return null if not found
        return null;
    }

    // Create a new receiver
    public receiver createReceiver(receiver newReceiver) {
        newReceiver.setRId(nextReceiverId++);
        receivers.add(newReceiver);
        return newReceiver;
    }

    // Update an existing receiver
    public receiver updateReceiver(int receiverId, receiver updatedReceiver) {
        for (int i = 0; i < receivers.size(); i++) {
            receiver r = receivers.get(i);
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
            receiver r = receivers.get(i);
            if (r.getRId() == receiverId) {
                receivers.remove(i);
                return true;
            }
        }
        return false;
    }
}

