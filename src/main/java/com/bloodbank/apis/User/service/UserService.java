//package com.bloodbank.apis.user.service;
//
//import com.bloodbank.apis.user.model.blooduser;
//
//import java.util.List;
//
//public class UserService {
//    public List<blooduser> getAllUsers() {
//    }
//
//    public blooduser getUserById(int userId) {
//    }
//
//    public blooduser createUser(blooduser newUser) {
//    }
//
//    public blooduser updateUser(int userId, blooduser updatedUser) {
//    }
//
//    public boolean deleteUser(int userId) {
//    }
//}
package com.bloodbank.apis.User.service;

import com.bloodbank.apis.User.model.BloodUser;
import com.bloodbank.apis.User.repo.UserRepository;
import org.apache.catalina.Loader;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    private List<BloodUser> users = new ArrayList<>();
    private int nextUserId = 1;

    // Get all users
    public List<BloodUser> getAllUsers() {
        return users;
    }

    // Get a user by ID
    public BloodUser getUserById(int userId) {
        // Implement logic to retrieve user by ID
        // Return null if not found
        return null;
    }

    // Create a new user
    public BloodUser createUser(BloodUser newUser) {
        users.add(newUser);
        userRepository.save(newUser);
        return newUser;
    }

    // Update an existing user
    public BloodUser updateUser(Long userId, BloodUser updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            BloodUser user = users.get(i);
            if (user.getId() == userId) {
                updatedUser.setId(userId);
                users.set(i, updatedUser);
                return updatedUser;
            }
        }
        return null;
    }

    // Delete a user by ID
//    public boolean deleteUser(Long userId) {
//        for (int i = 0; i < users.size(); i++) {
//            BloodUser user = users.get(i);
//            if (user.getId() == userId) {
//                users.remove(i);
//                userRepository.deleteById(userId);
//                return true;
//            }
//        }
//        return false;
//    }


    public Boolean deleteuser (Long userId){
        userRepository.deleteById(userId);
        return true;
    }
}
