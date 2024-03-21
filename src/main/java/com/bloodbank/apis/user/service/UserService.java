
package com.bloodbank.apis.user.service;

import com.bloodbank.apis.user.model.BloodUser;
import com.bloodbank.apis.user.repo.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    private List<BloodUser> users = new ArrayList<>();


    public List<BloodUser> getAllUsers() {
        return userRepository.findAll();
    }


    public BloodUser getUserById(Long userId) {
        Optional<BloodUser> userOptional  = userRepository.findById(userId);
        return userOptional.get();
    }


    public BloodUser createUser(BloodUser newUser) {
        userRepository.save(newUser);
        return newUser;
    }

    public BloodUser updateUser(Long userId, BloodUser updatedUser) {
        Optional<BloodUser> bloodUserOptional  = userRepository.findById(userId);
        BloodUser updateuser = bloodUserOptional.get();
        updateuser.setFirstName(updateuser.getFirstName());
        updateuser.setLastName(updateuser.getLastName());
        updateuser.setAddress(updateuser.getAddress());
        updateuser.setContactNumber(updateuser.getContactNumber());
        updateuser.setEmail(updateuser.getEmail());
        updateuser.setBloodGroup(updateuser.getBloodGroup());
        updateuser.setDisease(updateuser.getDisease());
        updateuser.setAge(updateuser.getAge());
        updateuser.setWeight(updateuser.getWeight());
        updateuser.setGender(updateuser.getGender());
        updateuser.setHeight(updateuser.getHeight());
        userRepository.save(updatedUser);
        return updatedUser;
    }

    public Boolean deleteuser (Long userId){
        userRepository.deleteById(userId);
        return true;

    }
}
