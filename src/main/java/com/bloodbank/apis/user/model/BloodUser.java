package com.bloodbank.apis.user.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Setter
@Getter
@Table(name = "blood_bank")
@Entity
@Validated

public class BloodUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank(message = "firstname is mandatory")
  private String firstName;
  private String lastName;
  private String address;
  private String contactNumber;
  private String email;
  private String bloodGroup;
  private String disease;
  private String gender;
  private String age;
  private String weight;
  private String height;


}

