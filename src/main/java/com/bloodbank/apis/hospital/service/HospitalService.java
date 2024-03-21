
package com.bloodbank.apis.hospital.service;

import com.bloodbank.apis.donor.model.Donor;
import com.bloodbank.apis.hospital.model.Hospital;
import com.bloodbank.apis.hospital.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {

  @Autowired
  private HospitalRepository hospitalRepository;


  public Hospital getHospitalById(Long id) {
    return hospitalRepository.findById(id).get();
  }


  public Hospital createHospital(Hospital newHospital) {
    hospitalRepository.save(newHospital);
    return newHospital;
  }

  // Update an existing hospital
  public Hospital updateHospital(Long hospitalId, Hospital hospital) {

    Optional<Hospital> hospitalOptional = hospitalRepository.findById(hospitalId);
    Hospital updateHospital = hospitalOptional.get();
    updateHospital.setHospitalName(hospital.getHospitalName());
    updateHospital.setHospitalAddress(hospital.getHospitalAddress());
    Hospital updatedHospital = hospitalRepository.save(updateHospital);
    return updatedHospital;

  }


  public boolean deleteHospital(Long hospitalId) {
    hospitalRepository.deleteById(hospitalId);
    return true;
  }

  public List<Hospital> getAllHospitals() {
    return hospitalRepository.findAll();
  }
}

