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
package com.bloodbank.apis.user.service;

import com.bloodbank.apis.user.model.blooduser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<blooduser> users = new ArrayList<>();
    private int nextUserId = 1;

    // Get all users
    public List<blooduser> getAllUsers() {
        return users;
    }

    // Get a user by ID
    public blooduser getUserById(int userId) {
        // Implement logic to retrieve user by ID
        // Return null if not found
        return null;
    }

    // Create a new user
    public blooduser createUser(blooduser newUser) {
        newUser.setId(nextUserId++);
        users.add(newUser);
        return newUser;
    }

    // Update an existing user
    public blooduser updateUser(int userId, blooduser updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            blooduser user = users.get(i);
            if (user.getId() == userId) {
                updatedUser.setId(userId);
                users.set(i, updatedUser);
                return updatedUser;
            }
        }
        return null;
    }

    // Delete a user by ID
    public boolean deleteUser(int userId) {
        for (int i = 0; i < users.size(); i++) {
            blooduser user = users.get(i);
            if (user.getId() == userId) {
                users.remove(i);
                return true;
            }
        }
        return false;
    }
}
