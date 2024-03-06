package com.bloodbank.apis.Receiver.rest;

//public class receivercontroller {
//}
//package com.bloodbank.apis.receiver.controller;

import com.bloodbank.apis.Receiver.model.Receiver;
import com.bloodbank.apis.Receiver.service.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receivers")
public class ReceiverController {

    @Autowired
    private ReceiverService receiverService;

    // Get all receivers
    @GetMapping
    public ResponseEntity<List<Receiver>> getAllReceivers() {
        List<Receiver> receivers = receiverService.getAllReceivers();
        return new ResponseEntity<>(receivers, HttpStatus.OK);
    }

    // Get a receiver by ID
    @GetMapping("/{receiverId}")
    public ResponseEntity<Receiver> getReceiverById(@PathVariable int receiverId) {
        Receiver receiver = receiverService.getReceiverById(receiverId);
        if (receiver != null) {
            return new ResponseEntity<>(receiver, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new receiver
    @PostMapping("/create")
    public ResponseEntity<Receiver> createReceiver(@RequestBody Receiver newReceiver) {
        Receiver createdReceiver = receiverService.createReceiver(newReceiver);
        return new ResponseEntity<>(createdReceiver, HttpStatus.CREATED);
    }

    // Update an existing receiver
    @PutMapping("/{receiverId}")
    public ResponseEntity<Receiver> updateReceiver(@PathVariable int receiverId, @RequestBody Receiver updatedReceiver) {
        Receiver receiver = receiverService.updateReceiver(receiverId, updatedReceiver);
        if (receiver != null) {
            return new ResponseEntity<>(receiver, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a receiver by ID
//    @DeleteMapping("/{receiverId}")
//    public ResponseEntity<Void> deleteReceiver(@PathVariable int receiverId) {
//        boolean deleted = receiverService.deleteReceiver(receiverId);
//        if (deleted) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    @DeleteMapping("/{receiverId}")
    public ResponseEntity<Void> deleteReceiver(@PathVariable int receiverId) {
        boolean deleted = receiverService.deleteReceiver(receiverId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

