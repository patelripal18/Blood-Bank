package com.bloodbank.apis.User.rest;

import com.bloodbank.apis.User.model.BloodUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//public class usercontroller {
//
//}
//package com.bloodbank.apis.user.controller;

import com.bloodbank.apis.User.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.BooleanControl;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Get all users
    @GetMapping
    public ResponseEntity<List<BloodUser>> getAllUsers() {
        List<BloodUser> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Get a user by ID
    @GetMapping("/{userId}")
    public ResponseEntity<BloodUser> getUserById(@PathVariable int userId) {
        BloodUser user = userService.getUserById(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new user
    @PostMapping("/create")
    public ResponseEntity<BloodUser> createUser(@RequestBody BloodUser newUser) {
        BloodUser createdUser = userService.createUser(newUser);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Update an existing user
    @PutMapping("/{userId}")
    public ResponseEntity<BloodUser> updateUser(@PathVariable Long userId, @RequestBody BloodUser updatedUser) {
        BloodUser user = userService.updateUser(userId, updatedUser);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a user by ID
//    @DeleteMapping("/{userId}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
//        boolean deleted = userService.deleteUser(userId);
//        if (deleted) {
//            return new ResponseEntity<>(HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<Boolean> deletedUser(@PathVariable Long userId){
        Boolean userDelete  = userService.deleteuser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}






