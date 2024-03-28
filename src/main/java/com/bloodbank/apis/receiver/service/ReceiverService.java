package com.bloodbank.apis.receiver.service;

import com.bloodbank.apis.bloodstatistics.model.BloodStatistics;
import com.bloodbank.apis.bloodstatistics.repository.BloodStatisticsRepository;
import com.bloodbank.apis.bloodstatistics.service.BloodStatisticsService;
import com.bloodbank.apis.receiver.model.Receiver;
import com.bloodbank.apis.receiver.repository.ReceiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceiverService {

  @Autowired
  private ReceiverRepository receiverRepository;

  @Autowired
  private BloodStatisticsRepository bloodStatisticsRepository;

  @Autowired
  public BloodStatisticsService bloodStatisticsService;


  public List<Receiver> getAllReceivers() {
    return receiverRepository.findAll();
  }


  public Receiver getReceiverById(Long receiverId) {
    Optional<Receiver> receiverOptional = receiverRepository.findById(receiverId);
    return receiverOptional.get();
  }


  public Receiver createReceiver(Receiver newReceiver) {
    receiverRepository.save(newReceiver);
    //update stats
    Optional<BloodStatistics> bloodStatisticsOptional = bloodStatisticsRepository.findByBloodGroup(
        newReceiver.getBloodGroup());
    if (bloodStatisticsOptional.isEmpty()){
      BloodStatistics bs = new BloodStatistics();
      bs.setQuantity(2);
      bs.setBloodGroup("A+");
      bloodStatisticsService.createBloodStatistics(bs);
    }else {
      BloodStatistics  bloodStatistics = bloodStatisticsOptional.get();
      bloodStatisticsService.updateBloodStatistics(bloodStatistics.getId(), bloodStatistics,false);
    }
    return newReceiver;
  }


  public Receiver updateReceiver(Long receiverId, Receiver receiver) {

    Optional<Receiver> receiverOptional = receiverRepository.findById(receiverId);
    Receiver updateReceiver = receiverOptional.get();
    updateReceiver.setQuantity(receiver.getQuantity());
    updateReceiver.setHospitalId(receiver.getHospitalId());
    updateReceiver.setBloodGroup(receiver.getBloodGroup());
    updateReceiver.setReceiveDate(receiver.getReceiveDate());
    updateReceiver.setContactNumber(receiver.getContactNumber());
    Receiver updatedReceiver = receiverRepository.save(updateReceiver);
    BloodStatistics stats = bloodStatisticsService.getBloodStatisticsByBloodGroup("A+");
    if (stats == null){
      BloodStatistics bs = new BloodStatistics();
      bs.setQuantity(1);
      bs.setBloodGroup("A+");
      bloodStatisticsService.createBloodStatistics(bs);
    }else {
      bloodStatisticsService.updateBloodStatistics(stats.getId(), stats,false);
    }
    return updatedReceiver;
  }

  public boolean deleteReceiver(Long receiverId) {
    receiverRepository.deleteById(receiverId);

    return false;
  }
}

