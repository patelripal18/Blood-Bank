package com.bloodbank.apis.user.rest;

import com.bloodbank.apis.user.model.BloodUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//public class usercontroller {
//
//}
//package com.bloodbank.apis.user.controller;

import com.bloodbank.apis.user.service.BloodUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class BloodUserController {

  @Autowired
  private BloodUserService userService;


  @GetMapping
  public ResponseEntity<List<BloodUser>> getAllUsers() {
    List<BloodUser> users = userService.getAllUsers();
    return new ResponseEntity<>(users, HttpStatus.OK);
  }


  @GetMapping("/{userId}")

  public ResponseEntity<BloodUser> getUserById(@PathVariable Long userId) {
    BloodUser user = userService.getUserById(userId);
    if (user != null) {
      return new ResponseEntity<>(user, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping("/create")
  public ResponseEntity<BloodUser> createUser(@RequestBody BloodUser newUser) {
    BloodUser createdUser = userService.createUser(newUser);
    return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
  }


  @PutMapping("/{userId}")
  public ResponseEntity<BloodUser> updateUser(@PathVariable Long userId,
      @RequestBody BloodUser updatedUser) {
    BloodUser bloodUser = userService.updateUser(userId, updatedUser);

    if (bloodUser != null) {
      return new ResponseEntity<>(bloodUser, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @DeleteMapping("/{userId}")
  public ResponseEntity<String> deletedUser(@PathVariable Long userId) {
    Boolean userDelete = userService.deleteuser(userId);
    return ResponseEntity.ok().body("UserId deleted successfully");
  }
}






