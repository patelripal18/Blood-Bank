
package com.bloodbank.apis.user.service;

import com.bloodbank.apis.user.model.BloodUser;
import com.bloodbank.apis.user.repo.UserRepository;
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
    private int nextUserId = 1;

    // Get all users
    public List<BloodUser> getAllUsers() {
        return userRepository.findAll();
    }

    // Get a user by ID
    public BloodUser getUserById(Long userId) {
        Optional<BloodUser> userOptional  = userRepository.findById(userId);
        return userOptional.get();
    }

    // Create a new user
    public BloodUser createUser(BloodUser newUser) {
        userRepository.save(newUser);
        return newUser;
    }

    // Update an existing user
    public BloodUser updateUser(Long userId, BloodUser updatedUser) {
        Optional<BloodUser> bloodUser  = userRepository.findById(userId);
        userRepository.save(updatedUser);
        return updatedUser;
    }

    public Boolean deleteuser (Long userId){
        userRepository.deleteById(userId);
        return true;

    }
}
