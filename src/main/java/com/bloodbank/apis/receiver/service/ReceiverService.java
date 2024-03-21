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
    private  ReceiverRepository receiverRepository;
    private List<Receiver> receivers = new ArrayList<>();

    public List<Receiver> getAllReceivers() {
      return receiverRepository.findAll();
    }


    public Receiver getReceiverById(int receiverId) {
        Optional<Receiver> receiverOptional  = receiverRepository.findById(receiverId);
        return receiverOptional.get();
    }


    public Receiver createReceiver(Receiver newReceiver) {
        receiverRepository.save(newReceiver);
        return newReceiver;
    }


    public Receiver updateReceiver(int receiverId, Receiver updatedReceiver) {

        Optional<Receiver> receiverOptional  = receiverRepository.findById(receiverId);
        Receiver updateReceiver = receiverOptional.get();
        updateReceiver.setQuantity(updateReceiver.getQuantity());
        updateReceiver.setHospitalId(updateReceiver.getHospitalId());
        updateReceiver.setBloodGroup(updateReceiver.getBloodGroup());
        updateReceiver.setReceiveDate(updatedReceiver.getReceiveDate());
        updateReceiver.setReceiverNo(updateReceiver.getReceiverNo());
        updateReceiver.setUnit(updateReceiver.getUnit());
        receiverRepository.save(updatedReceiver);
        return updatedReceiver;
    }
    public boolean deleteReceiver(int receiverId) {
        receiverRepository.deleteById(receiverId);
        return true;
    }
}

