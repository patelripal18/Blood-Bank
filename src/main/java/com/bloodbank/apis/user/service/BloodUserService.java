
package com.bloodbank.apis.user.service;

import com.bloodbank.apis.user.model.BloodUser;
import com.bloodbank.apis.user.repo.BloodUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BloodUserService {

  @Autowired
  public BloodUserRepository userRepository;




  public List<BloodUser> getAllUsers() {
    return userRepository.findAll();
  }


  public BloodUser getUserById(Long userId) {
    Optional<BloodUser> userOptional = userRepository.findById(userId);
    return userOptional.get();
  }


  public BloodUser createUser(BloodUser newUser) {
    userRepository.save(newUser);
    return newUser;
  }

  public BloodUser updateUser(Long userId, BloodUser bloodUser) {
    Optional<BloodUser> bloodUserOptional = userRepository.findById(userId);
    BloodUser updateuser = bloodUserOptional.get();
    updateuser.setFirstName(bloodUser.getFirstName());
    updateuser.setLastName(bloodUser.getLastName());
    updateuser.setAddress(bloodUser.getAddress());
    updateuser.setContactNumber(bloodUser.getContactNumber());
    updateuser.setEmail(bloodUser.getEmail());
    updateuser.setBloodGroup(bloodUser.getBloodGroup());
    updateuser.setDisease(bloodUser.getDisease());
    updateuser.setAge(bloodUser.getAge());
    updateuser.setWeight(bloodUser.getWeight());
    updateuser.setGender(bloodUser.getGender());
    updateuser.setHeight(bloodUser.getHeight());
    BloodUser updatedUser = userRepository.save(updateuser);
    return updatedUser;
  }

  public Boolean deleteuser(Long userId) {
    userRepository.deleteById(userId);
    return true;

  }
}
