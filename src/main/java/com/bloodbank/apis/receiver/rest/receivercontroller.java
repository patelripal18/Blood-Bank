package com.bloodbank.apis.receiver.rest;

//public class receivercontroller {
//}
//package com.bloodbank.apis.receiver.controller;

import com.bloodbank.apis.receiver.model.receiver;
import com.bloodbank.apis.receiver.service.receiverservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receivers")
public class receivercontroller {

    @Autowired
    private receiverservice receiverService;

    // Get all receivers
    @GetMapping
    public ResponseEntity<List<receiver>> getAllReceivers() {
        List<receiver> receivers = receiverService.getAllReceivers();
        return new ResponseEntity<>(receivers, HttpStatus.OK);
    }

    // Get a receiver by ID
    @GetMapping("/{receiverId}")
    public ResponseEntity<receiver> getReceiverById(@PathVariable int receiverId) {
        receiver receiver = receiverService.getReceiverById(receiverId);
        if (receiver != null) {
            return new ResponseEntity<>(receiver, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new receiver
    @PostMapping("/create")
    public ResponseEntity<receiver> createReceiver(@RequestBody receiver newReceiver) {
        receiver createdReceiver = receiverService.createReceiver(newReceiver);
        return new ResponseEntity<>(createdReceiver, HttpStatus.CREATED);
    }

    // Update an existing receiver
    @PutMapping("/{receiverId}")
    public ResponseEntity<receiver> updateReceiver(@PathVariable int receiverId, @RequestBody receiver updatedReceiver) {
        receiver receiver = receiverService.updateReceiver(receiverId, updatedReceiver);
        if (receiver != null) {
            return new ResponseEntity<>(receiver, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a receiver by ID
    @DeleteMapping("/{receiverId}")
    public ResponseEntity<Void> deleteReceiver(@PathVariable int receiverId) {
        boolean deleted = receiverService.deleteReceiver(receiverId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

